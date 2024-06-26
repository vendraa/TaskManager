package com.example.taskmanager.domain.usecase.user

import com.example.taskmanager.domain.model.HeaderType
import com.example.taskmanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetHeaderType(
    private val userRepository: UserRepository,
) {
    operator fun invoke(): Flow<HeaderType> {
        return userRepository.getHeaderType()
    }
}