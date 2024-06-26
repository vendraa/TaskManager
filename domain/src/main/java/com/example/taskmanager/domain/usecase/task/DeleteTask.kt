package com.example.taskmanager.domain.usecase.task

import com.example.taskmanager.domain.repository.TaskRepository
import java.util.UUID

class DeleteTask(
    private val taskRepository: TaskRepository,
) {
    suspend operator fun invoke(id: UUID?) {
        id?.let {
            taskRepository.deleteById(id)
        }
    }
}