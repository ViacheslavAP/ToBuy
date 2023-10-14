package ru.perelyginva.tobuy.presentation

import androidx.fragment.app.Fragment
import ru.perelyginva.tobuy.data.database.AppDatabase

class BaseFragment: Fragment() {

    protected val mainActivity: MainActivity
        get() = activity as MainActivity

    protected val appDatabase: AppDatabase
        get() = AppDatabase.getDatabase(requireActivity())
}