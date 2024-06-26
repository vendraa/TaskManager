package com.example.taskmanager.data.local.db

import androidx.room.TypeConverter
import com.example.taskmanager.domain.model.PriorityType
import com.example.taskmanager.domain.model.StatusType
import com.example.taskmanager.domain.model.StatusType.Companion.toStatusType
import com.example.taskmanager.domain.model.StatusType.Companion.toValue
import java.util.UUID

class RoomTypeConverters {

    @TypeConverter
    fun fromPriorityType(priorityType: PriorityType): String = priorityType.name

    @TypeConverter
    fun toPriorityType(priorityType: String): PriorityType = PriorityType.valueOf(priorityType)

    @TypeConverter
    fun fromUUID(id: UUID?): String? = id?.toString()

    @TypeConverter
    fun toUUID(id: String?): UUID? = id?.let { UUID.fromString(it) }

    @TypeConverter
    fun fromStatusType(statusType: StatusType): String = statusType.toValue()

    @TypeConverter
    fun toStatusType(statusType: String): StatusType = statusType.toStatusType()
}