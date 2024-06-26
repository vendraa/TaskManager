package com.example.taskmanager.data.repository.mapper

import com.example.taskmanager.data.local.db.entity.NoteEntity
import com.example.taskmanager.domain.model.Note

object NoteMapper {

    fun NoteEntity.toDomain(): Note {
        return Note(
            id = id,
            title = title,
            description = description,
            createdAt = createdAt
        )
    }

    fun Note.toEntity(): NoteEntity {
        return this.id.let {
            if (it == null) {
                NoteEntity(
                    title = title,
                    description = description,
                    createdAt = createdAt
                )
            } else {
                NoteEntity(
                    id = it,
                    title = title,
                    description = description,
                    createdAt = createdAt
                )
            }
        }
    }

    fun List<NoteEntity>.toDomain(): List<Note> {
        return map { it.toDomain() }
    }

    fun List<Note>.toEntity(): List<NoteEntity> {
        return map { it.toEntity() }
    }
}