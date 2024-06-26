package com.example.taskmanager.service.scheduler

import com.example.taskmanager.domain.model.Task
import java.util.UUID

interface TaskScheduler {
    fun setTask(task: Task)
    fun cancelTask(id: UUID)
}