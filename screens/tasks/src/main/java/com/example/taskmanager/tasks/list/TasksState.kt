package com.example.taskmanager.tasks.list

import com.example.taskmanager.domain.model.HeaderType
import com.example.taskmanager.domain.model.Task
import com.example.taskmanager.domain.model.StatusType
import com.example.taskmanager.domain.model.TimeType
import java.time.LocalDate

data class TasksState(
    val tasks: List<Task> = emptyList(),
    val status : StatusType? = null,
    val selectedDate: LocalDate = LocalDate.now(),
    val selectedTime: TimeType = TimeType.TODAY,
    val headerType: HeaderType = HeaderType.CALENDAR,
    val showDialog : Boolean = false,
    val selectedTask: Task? = null,
    val showSearchBar : Boolean = false,
    val searchQuery : String = ""
)