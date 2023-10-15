package ru.perelyginva.tobuy.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.perelyginva.tobuy.R
import ru.perelyginva.tobuy.data.model.ItemEntity
import ru.perelyginva.tobuy.databinding.FragmentHomeBinding
import ru.perelyginva.tobuy.domain.ItemEntityInterface
import ru.perelyginva.tobuy.presentation.epoxy.HomeEpoxyController


class HomeFragment : BaseFragment(), ItemEntityInterface {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            navigateViaNavGraph(R.id.action_homeFragment_to_addItemEntityFragment)
        }

        val controller = HomeEpoxyController(this)
        binding.epoxyRecyclerView.setController(controller)

        shareViewModel.itemEntitiesLiveData.observe(viewLifecycleOwner) { itemEntityList ->
            controller.itemEntityList = itemEntityList as ArrayList<ItemEntity>
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding == null
    }

    override fun onDeleteItemEntity(itemEntity: ItemEntity) {
        TODO("Not yet implemented")
    }

    override fun onBumpItemEntity(itemEntity: ItemEntity) {
        TODO("Not yet implemented")
    }
}