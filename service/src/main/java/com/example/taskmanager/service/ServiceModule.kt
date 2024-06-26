package com.example.taskmanager.service

import android.content.Context
import com.example.taskmanager.service.scheduler.AlarmTaskScheduler
import com.example.taskmanager.service.scheduler.TaskScheduler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideTaskScheduler(
        @ApplicationContext context: Context
    ): TaskScheduler = AlarmTaskScheduler(context)

    @Provides
    @Singleton
    fun provideTaskNotification(
        @ApplicationContext context: Context
    ): TaskNotification = TaskNotification(context)
}