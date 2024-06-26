package com.example.taskmanager.data.di

import android.content.Context
import com.example.taskmanager.data.local.db.TaskManagerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDbModule {

    @Provides
    @Singleton
    fun provideRemindTaskDatabase(
        @ApplicationContext context: Context,
    ): TaskManagerDatabase = TaskManagerDatabase.create(context)

    @Provides
    fun provideTaskDao(remindTaskDatabase: TaskManagerDatabase) = remindTaskDatabase.taskDao

    @Provides
    fun provideNoteDao(remindTaskDatabase: TaskManagerDatabase) = remindTaskDatabase.noteDao
}