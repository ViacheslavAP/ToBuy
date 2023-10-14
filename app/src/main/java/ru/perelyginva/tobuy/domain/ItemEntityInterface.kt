package ru.perelyginva.tobuy.domain

import ru.perelyginva.tobuy.data.model.ItemEntity

interface ItemEntityInterface {

    fun onDeleteItemEntity(itemEntity: ItemEntity)
    fun onBumpItemEntity(itemEntity: ItemEntity)
}