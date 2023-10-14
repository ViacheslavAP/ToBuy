package ru.perelyginva.tobuy.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.perelyginva.tobuy.R
import ru.perelyginva.tobuy.data.database.AppDatabase
import ru.perelyginva.tobuy.presentation.viewModel.ToByViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //иниализируем viewModel
        val viewModel:ToByViewModel by viewModels()
        viewModel.init(AppDatabase.getDatabase(this))

    }

}