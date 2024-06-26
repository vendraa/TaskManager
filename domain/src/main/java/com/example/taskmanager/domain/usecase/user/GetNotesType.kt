package com.example.taskmanager.domain.usecase.user

import com.example.taskmanager.domain.model.NotesType
import com.example.taskmanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetNotesType(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<NotesType> =
        userRepository.getNotesType()
}
