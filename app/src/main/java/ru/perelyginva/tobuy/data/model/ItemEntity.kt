package ru.perelyginva.tobuy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_entity")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: String = "",
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "descriptions")
    val descriptions: String? = null,
    @ColumnInfo(name = "priority")
    val priority: Int = 0 ,
    @ColumnInfo(name = "createdAt")
    val createdAt: Long = 0L,
    @ColumnInfo(name = "categoryId")
    val categoryId: String = ""
)
