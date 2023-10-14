package ru.perelyginva.tobuy.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.perelyginva.tobuy.R
import ru.perelyginva.tobuy.data.model.AppDatabase

class MainActivity : AppCompatActivity() {

   private val appDatabase: RoomDatabase by lazy {
       Room.databaseBuilder(
           this,
           AppDatabase::class.java, "to_by_database"
       ).build()
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}