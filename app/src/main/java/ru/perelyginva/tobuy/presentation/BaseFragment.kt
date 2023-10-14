package ru.perelyginva.tobuy.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import ru.perelyginva.tobuy.data.database.AppDatabase
import ru.perelyginva.tobuy.presentation.viewModel.ToByViewModel

open class BaseFragment: Fragment() {

    protected val mainActivity: MainActivity
        get() = activity as MainActivity

    protected val appDatabase: AppDatabase
        get() = AppDatabase.getDatabase(requireActivity())

    protected val shareViewModel: ToByViewModel by activityViewModels()

}