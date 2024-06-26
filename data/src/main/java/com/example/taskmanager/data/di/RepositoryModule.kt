package com.example.taskmanager.data.di

import com.example.taskmanager.data.local.db.dao.NoteDao
import com.example.taskmanager.data.local.db.dao.TaskDao
import com.example.taskmanager.data.local.preferences.UserPreferences
import com.example.taskmanager.data.repository.NoteRepositoryImpl
import com.example.taskmanager.data.repository.TaskRepositoryImpl
import com.example.taskmanager.data.repository.UserRepositoryImpl
import com.example.taskmanager.domain.repository.NoteRepository
import com.example.taskmanager.domain.repository.TaskRepository
import com.example.taskmanager.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository = TaskRepositoryImpl(taskDao)

    @Provides
    @Singleton
    fun provideUserRepository(userPreferences: UserPreferences): UserRepository = UserRepositoryImpl(userPreferences)

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)
}