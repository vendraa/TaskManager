package com.example.taskmanager.notes.list

import com.example.taskmanager.domain.model.NotesType

sealed class NotesEvent {
    data class OnNotesTypeChange(val notesType: NotesType) : NotesEvent()
    data class OnSearchQueryChange(val query: String) : NotesEvent()
    data class OnShowSearchBarChange(val showSearchBar: Boolean) : NotesEvent()
}