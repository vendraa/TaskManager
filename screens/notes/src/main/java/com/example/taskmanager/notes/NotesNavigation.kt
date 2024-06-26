package com.example.taskmanager.notes

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.taskmanager.domain.model.Note
import com.example.taskmanager.notes.list.NotesEvent
import com.example.taskmanager.notes.list.NotesScreen
import com.example.taskmanager.notes.list.NotesViewModel

fun NavGraphBuilder.notesScreen(
    navigateToEditNote: (Note) -> Unit,
) {
    composable(route = com.example.taskmanager.navigation.Screens.Notes.route) {
        val viewModel = hiltViewModel<NotesViewModel>()
        val state = viewModel.state.value
        val event = viewModel::onEvent

        NotesScreen(
            state = state,
            onNotesTypeChange = {
                event(
                    NotesEvent.OnNotesTypeChange(
                        it
                    )
                )
            },
            onSearchQueryChange = {
                event(
                    NotesEvent.OnSearchQueryChange(
                        it
                    )
                )
            },
            onShowSearchBar = {
                event(
                    NotesEvent.OnShowSearchBarChange(
                        it
                    )
                )
            },
            onNoteClick = { navigateToEditNote(it) }
        )
    }
}