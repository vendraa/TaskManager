package com.example.taskmanager.domain.usecase.user

import com.example.taskmanager.domain.model.HeaderType
import com.example.taskmanager.domain.repository.UserRepository

class SaveHeaderType(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(headerType: HeaderType) {
        userRepository.saveHeaderType(headerType)
    }
}