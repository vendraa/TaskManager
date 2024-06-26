package com.example.taskmanager.domain.usecase.note

import com.example.taskmanager.domain.model.InvalidNoteException
import com.example.taskmanager.domain.model.Note
import com.example.taskmanager.domain.repository.NoteRepository

class AddNote(
    private val noteRepository: NoteRepository,
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank() && note.description.isBlank()) {
            throw InvalidNoteException("Title and description cannot be empty. Please fill one of them.")
        }
        noteRepository.save(note)
    }
}
