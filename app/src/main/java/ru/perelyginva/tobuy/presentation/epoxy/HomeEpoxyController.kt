package ru.perelyginva.tobuy.presentation.epoxy

import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.airbnb.epoxy.EpoxyController
import ru.perelyginva.tobuy.R
import ru.perelyginva.tobuy.data.model.ItemEntity
import ru.perelyginva.tobuy.databinding.ModelItemEntityBinding
import ru.perelyginva.tobuy.domain.ItemEntityInterface

class HomeEpoxyController (
    private  val itemEntityInterface: ItemEntityInterface
) : EpoxyController() {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var itemEntityList = ArrayList<ItemEntity>()
        set(value) {
            field = value
            isLoading = false
            requestModelBuild()
        }

    override fun buildModels() {

        if (isLoading) {
             LoadingEpoxyModel().id("loading_state").addTo(this)
            return
        }

        if (itemEntityList.isEmpty()) {
            //todo empty list
            return
        }

        itemEntityList.forEach { item ->
            ItemEntityEpoxyModel(item, itemEntityInterface).id(item.id).addTo(this)
        }
    }

    data class ItemEntityEpoxyModel(
        val itemEntity: ItemEntity,
        private  val itemEntityInterface: ItemEntityInterface
    ) : ViewBindingKotlinModel<ModelItemEntityBinding>(R.layout.model_item_entity) {

        override fun ModelItemEntityBinding.bind() {
            titleTv.text = itemEntity.title
            /** если описание пусто, то и не показываем его
             * */
            if (itemEntity.descriptions == null) {
                descriptionTv.isGone = true
            } else {
                descriptionTv.isVisible = true
                descriptionTv.text = itemEntity.descriptions
            }

            deleteIv.setOnClickListener {
                itemEntityInterface.onDeleteItemEntity(itemEntity)
            }

            priorityTv.setOnClickListener {
                itemEntityInterface.onBumpItemEntity(itemEntity)
            }

           val colorRes = when(itemEntity.priority){
                1 -> android.R.color.holo_green_light
                2 -> android.R.color.holo_orange_light
                3 -> android.R.color.holo_red_light
               else -> R.color.teal_700
            }
            priorityTv.setBackgroundColor(ContextCompat.getColor(root.context,colorRes))
        }
    }
}
//Inserting into Room database. 6 video