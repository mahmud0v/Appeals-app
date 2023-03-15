package uz.gita.appealsapp.repository

import uz.gita.appealsapp.database.AppealDao
import uz.gita.appealsapp.database.AppealEntity
import javax.inject.Inject

class AppealRepository @Inject constructor(
    private val appealDao: AppealDao
) {

    fun getAllRepository() = appealDao.getAllAppeals()

    suspend fun updateAppeal(appealEntity: AppealEntity) = appealDao.updateAppeal(appealEntity)

    fun getAllowedAppeals() = appealDao.getAllowedAppeals()


}