package com.example.taskmanager.notes.add

import com.example.taskmanager.domain.model.Note


sealed class AddNoteEvent {
    data class OnTitleChange(val title: String) : AddNoteEvent()
    data class OnDescriptionChange(val description: String) : AddNoteEvent()
    data class OnShowDeleteDialog(val show: Boolean) : AddNoteEvent()
    data class OnShowDiscardDialog(val show: Boolean) : AddNoteEvent()
    data object OnSaveNoteClick : AddNoteEvent()
    data object OnEditNoteClick : AddNoteEvent()
    data object OnDeleteNoteClick : AddNoteEvent()
    data class OnInitState(val note: Note?) : AddNoteEvent()
    data object OnRestoreNote : AddNoteEvent()
}