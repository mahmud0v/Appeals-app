package uz.gita.appealsapp.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppealDao {

    @Query("select *from Appeals")
    fun getAllAppeals(): Flow<List<AppealEntity>>


}