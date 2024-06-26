package com.example.taskmanager.domain.usecase.note

import com.example.taskmanager.domain.model.Note
import com.example.taskmanager.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotes(
    private val noteRepository: NoteRepository,
) {
    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getAll()
    }

    fun filter(
        notes: List<Note>,
        searchQuery: String,
    ): List<Note> {
        return notes.filter {
            filterNotesByQuery(it, searchQuery)
        }
    }

    private fun filterNotesByQuery(note: Note, searchQuery: String): Boolean {
        return note.title.contains(searchQuery, ignoreCase = true) ||
                note.description.contains(searchQuery, ignoreCase = true)
    }
}
