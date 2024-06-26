package com.example.taskmanager.notes.list

import com.example.taskmanager.domain.model.Note
import com.example.taskmanager.domain.model.NotesType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val notesType: NotesType = NotesType.LIST,
    val searchQuery: String = "",
    val showSearchBar: Boolean = false
)
