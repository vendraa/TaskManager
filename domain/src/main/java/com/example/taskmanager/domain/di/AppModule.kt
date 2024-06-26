package com.example.taskmanager.domain.di

import com.example.taskmanager.domain.repository.NoteRepository
import com.example.taskmanager.domain.repository.TaskRepository
import com.example.taskmanager.domain.repository.UserRepository
import com.example.taskmanager.domain.usecase.note.AddNote
import com.example.taskmanager.domain.usecase.note.DeleteNote
import com.example.taskmanager.domain.usecase.note.GetNotes
import com.example.taskmanager.domain.usecase.note.NoteUseCases
import com.example.taskmanager.domain.usecase.task.AddTask
import com.example.taskmanager.domain.usecase.task.CheckTask
import com.example.taskmanager.domain.usecase.task.DeleteTask
import com.example.taskmanager.domain.usecase.task.GetTasks
import com.example.taskmanager.domain.usecase.task.TaskUseCases
import com.example.taskmanager.domain.usecase.user.GetHeaderType
import com.example.taskmanager.domain.usecase.user.GetNotesType
import com.example.taskmanager.domain.usecase.user.SaveHeaderType
import com.example.taskmanager.domain.usecase.user.SaveNotesType
import com.example.taskmanager.domain.usecase.user.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideTasksUseCase(
        taskRepository: TaskRepository,
    ): TaskUseCases = TaskUseCases(
        getTasks = GetTasks(taskRepository),
        addTask = AddTask(taskRepository),
        checkTask = CheckTask(taskRepository),
        deleteTask = DeleteTask(taskRepository)
    )

    @Provides
    fun provideUsersUseCase(
        userRepository: UserRepository,
    ): UserUseCase = UserUseCase(
        getHeaderType = GetHeaderType(userRepository),
        saveHeaderType = SaveHeaderType(userRepository),
        getNotesType = GetNotesType(userRepository),
        saveNotesType = SaveNotesType(userRepository)
    )

    @Provides
    fun provideNotesUseCase(
        noteRepository: NoteRepository,
    ): NoteUseCases = NoteUseCases(
        getNotes = GetNotes(noteRepository),
        addNote = AddNote(noteRepository),
        deleteNote = DeleteNote(noteRepository)
    )
}