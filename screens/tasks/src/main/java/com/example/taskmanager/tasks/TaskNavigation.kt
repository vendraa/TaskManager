package com.example.taskmanager.tasks

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.taskmanager.domain.model.Task
import com.example.taskmanager.navigation.Screens
import com.example.taskmanager.tasks.list.TasksEvent
import com.example.taskmanager.tasks.list.TasksScreen
import com.example.taskmanager.tasks.list.TasksViewModel

fun NavGraphBuilder.tasksScreen(
    navigateToEditTask: (Task) -> Unit,
) {
    composable(route = Screens.Tasks.route) {
        val viewModel = hiltViewModel<TasksViewModel>()
        val state = viewModel.state.value
        val event = viewModel::onEvent

        TasksScreen(
            state = state,
            onStatusSelected = {
                event(
                    TasksEvent.OnStatusSelected(
                        it
                    )
                )
            },
            onTimeSelected = { event(TasksEvent.OnTimeSelected(it)) },
            onDateSelected = { event(TasksEvent.OnDateSelected(it)) },
            onHeaderTypeChange = {
                event(
                    TasksEvent.OnHeaderTypeChanged(
                        it
                    )
                )
            },
            onTaskClick = { navigateToEditTask(it) },
            onTaskCheck = { event(TasksEvent.OnTaskClick(it)) },
            onTaskDelete = { event(TasksEvent.OnTaskDelete(it)) },
            onShowDialog = { isShow, task ->
                event(
                    TasksEvent.OnShowDialog(
                        isShow,
                        task
                    )
                )
            },
            onShowSearchBar = { event(TasksEvent.OnShowSearchBar(it)) },
            onQueryChange = { event(TasksEvent.OnQueryChange(it)) }
        )
    }
}