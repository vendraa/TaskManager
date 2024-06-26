package com.example.taskmanager.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.domain.usecase.note.NoteUseCases
import com.example.taskmanager.domain.usecase.task.TaskUseCases
import com.example.taskmanager.utils.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    private val notesUseCases: NoteUseCases,
) : ViewModel() {
    fun init() {
        viewModelScope.launch {
            DummyData.generateTasks().map {
                taskUseCases.addTask(it)
            }

            DummyData.generateNotes().map {
                notesUseCases.addNote(it)
            }
        }
    }
}