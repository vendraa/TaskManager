package com.example.taskmanager.data.repository

import com.example.taskmanager.data.local.preferences.UserPreferences
import com.example.taskmanager.domain.model.HeaderType
import com.example.taskmanager.domain.model.NotesType
import com.example.taskmanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userPreferences: UserPreferences,
) : UserRepository {
    override suspend fun saveHeaderType(headerType: HeaderType) =
        userPreferences.saveHeaderType(headerType)

    override fun getHeaderType(): Flow<HeaderType> = userPreferences.headerType

    override suspend fun saveNotesType(notesType: NotesType) =
        userPreferences.saveNotesType(notesType)

    override fun getNotesType(): Flow<NotesType> = userPreferences.notesType
}