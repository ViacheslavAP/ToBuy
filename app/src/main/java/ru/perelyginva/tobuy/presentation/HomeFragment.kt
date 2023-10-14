package ru.perelyginva.tobuy.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.perelyginva.tobuy.R
import ru.perelyginva.tobuy.databinding.FragmentHomeBinding


class HomeFragment :  BaseFragment() {

private var _binding: FragmentHomeBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareViewModel.itemEntitiesLiveData.observe(viewLifecycleOwner){itemEntityList->


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding == null
    }
}