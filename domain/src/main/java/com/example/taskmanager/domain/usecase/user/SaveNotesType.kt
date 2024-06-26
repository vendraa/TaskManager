package com.example.taskmanager.domain.usecase.user

import com.example.taskmanager.domain.model.NotesType
import com.example.taskmanager.domain.repository.UserRepository

class SaveNotesType(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(notesType: NotesType) =
        userRepository.saveNotesType(notesType)
}
