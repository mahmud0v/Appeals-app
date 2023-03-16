package uz.gita.appealsapp.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AppealDao {

    @Query("select *from Appeals")
    fun getAllAppeals(): Flow<List<AppealEntity>>

    @Update
    suspend fun updateAppeal(appealEntity: AppealEntity)

    @Query("select *from Appeals where isAllow = 1")
    fun getAllowedAppeals(): Flow<List<AppealEntity>>


}