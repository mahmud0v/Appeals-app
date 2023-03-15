package uz.gita.appealsapp.repository

import uz.gita.appealsapp.database.AppealDao
import javax.inject.Inject

class AppealRepository @Inject constructor(
    private val appealDao: AppealDao
) {

    fun getAllRepository() = appealDao.getAllAppeals()


}