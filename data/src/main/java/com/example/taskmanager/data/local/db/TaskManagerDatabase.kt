package com.example.taskmanager.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taskmanager.data.local.db.dao.NoteDao
import com.example.taskmanager.data.local.db.dao.TaskDao
import com.example.taskmanager.data.local.db.entity.NoteEntity
import com.example.taskmanager.data.local.db.entity.TaskEntity

@Database(entities = [TaskEntity::class, NoteEntity::class], version = 3)
@TypeConverters(RoomTypeConverters::class)
abstract class TaskManagerDatabase : RoomDatabase() {
    abstract val taskDao: TaskDao
    abstract val noteDao: NoteDao

    companion object {
        fun create(applicationContext: Context): TaskManagerDatabase {
            return Room
                .databaseBuilder(
                    applicationContext,
                    TaskManagerDatabase::class.java,
                    DATABASE_NAME
                )
                .fallbackToDestructiveMigration()
                .build()
        }

        private const val DATABASE_NAME = "remind_task.db"
    }
}