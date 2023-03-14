package uz.gita.appealsapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        AppealDao::class
    ],
    version = 1
)
abstract class AppealDatabase : RoomDatabase() {

    abstract fun AppealDao(): AppealDao

}