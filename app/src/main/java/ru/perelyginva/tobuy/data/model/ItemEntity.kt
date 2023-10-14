package ru.perelyginva.tobuy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_entity")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long ,
    val title: String,
    val descriptions: String? = null,
    val priority: Int ,
    val createdAt: Long ,
    val categoryId: String
)
