package com.example.taskmanager.domain.usecase.task

import com.example.taskmanager.domain.model.InvalidTaskException
import com.example.taskmanager.domain.model.Task
import com.example.taskmanager.domain.repository.TaskRepository

class AddTask(
    private val taskRepository: TaskRepository,
) {

    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(task: Task) {
        if (task.title.isBlank()) {
            throw InvalidTaskException("Title cannot be empty")
        }

        if (task.deadline == 0L) {
            throw InvalidTaskException("Date and time cannot be empty")
        }

        taskRepository.save(task)
    }
}