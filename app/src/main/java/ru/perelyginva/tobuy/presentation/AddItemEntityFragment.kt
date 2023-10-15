package ru.perelyginva.tobuy.presentation

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.perelyginva.tobuy.R
import ru.perelyginva.tobuy.data.model.ItemEntity
import ru.perelyginva.tobuy.databinding.FragmentAddItemEntityBinding
import java.util.UUID


class AddItemEntityFragment : BaseFragment() {

    private var _binding: FragmentAddItemEntityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddItemEntityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener {
            saveItemEntityToDatabase()
        }
    }

    private fun saveItemEntityToDatabase() {
        val itemTitle = binding.titleEt.text.toString().trim()
        if (itemTitle.isEmpty()) {
            binding.titleTf.error = getString(R.string.required_field)
            return
        }
        binding.titleTf.error = null //если ошибка устранена, то и в поле не будет указана

        val itemDescriptions = binding.descriptionEt.text.toString().trim()
        val itemPriority = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.low_rb -> 1
            R.id.medium_rb -> 2
            R.id.high_rb -> 3
            else -> return
        }

        val itemEntity = ItemEntity(
            id = UUID.randomUUID().toString(),
            title = itemTitle,
            descriptions = itemDescriptions,
            priority = itemPriority,
            createdAt = System.currentTimeMillis(),
            categoryId = "" //todo update this late when we have categories in the app!
        )
        shareViewModel.insertItem(itemEntity)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding == null
    }
}