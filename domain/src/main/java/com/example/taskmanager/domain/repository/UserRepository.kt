package com.example.taskmanager.domain.repository

import com.example.taskmanager.domain.model.HeaderType
import com.example.taskmanager.domain.model.NotesType
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveHeaderType(headerType: HeaderType)
    fun getHeaderType(): Flow<HeaderType>
    suspend fun saveNotesType(notesType: NotesType)
    fun getNotesType(): Flow<NotesType>
}