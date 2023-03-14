package uz.gita.appealsapp.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppealDao {

    @Query("select *from Appeal")
    fun getAllAppeals():Flow<List<AppealEntity>>


}