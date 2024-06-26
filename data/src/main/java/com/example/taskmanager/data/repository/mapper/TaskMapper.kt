package com.example.taskmanager.data.repository.mapper

import com.example.taskmanager.data.local.db.entity.TaskEntity
import com.example.taskmanager.domain.model.Task

object TaskMapper {
    fun TaskEntity.toDomain(): Task {
        return Task(
            id = id,
            title = title,
            description = description,
            deadline = deadline,
            priority = priority,
            status = status
        )
    }

    fun Task.toEntity(): TaskEntity {
        return this.id.let {
            if (it == null) {
                TaskEntity(
                    title = title,
                    description = description,
                    deadline = deadline,
                    priority = priority,
                    status = status
                )
            } else {
                TaskEntity(
                    id = it,
                    title = title,
                    description = description,
                    deadline = deadline,
                    priority = priority,
                    status = status
                )
            }
        }
    }

    fun List<TaskEntity>.toDomain(): List<Task> {
        return map { it.toDomain() }
    }

    fun List<Task>.toEntity(): List<TaskEntity> {
        return map { it.toEntity() }
    }
}
