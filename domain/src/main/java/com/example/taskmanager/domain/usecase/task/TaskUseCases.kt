package com.example.taskmanager.domain.usecase.task

data class TaskUseCases(
    val getTasks: GetTasks,
    val addTask: AddTask,
    val checkTask: CheckTask,
    val deleteTask: DeleteTask
)