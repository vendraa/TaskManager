package com.example.taskmanager.data.repository

import com.example.taskmanager.data.local.db.dao.TaskDao
import com.example.taskmanager.data.repository.mapper.TaskMapper.toDomain
import com.example.taskmanager.data.repository.mapper.TaskMapper.toEntity
import com.example.taskmanager.domain.model.StatusType
import com.example.taskmanager.domain.model.Task
import com.example.taskmanager.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao,
) : TaskRepository {
    override fun getAll(): Flow<List<Task>> {
        return taskDao.getAll().map {
            it.toDomain()
        }
    }

    override suspend fun save(task: Task) {
        taskDao.save(task.toEntity())
    }

    override suspend fun deleteById(id: UUID) {
        taskDao.deleteById(id)
    }

    override suspend fun getById(id: UUID): Task? {
        return taskDao.getById(id)?.toDomain()
    }

    override suspend fun checkTask(task: Task) {
        task.id?.let {
            val status =
                if (task.status == StatusType.COMPLETED) StatusType.UNCOMPLETED else StatusType.COMPLETED
            taskDao.checkTask(it, status)
        }
    }
}