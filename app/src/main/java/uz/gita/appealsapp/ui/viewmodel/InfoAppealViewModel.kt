package uz.gita.appealsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.appealsapp.database.AppealEntity
import uz.gita.appealsapp.repository.AppealRepository
import javax.inject.Inject

@HiltViewModel
class InfoAppealViewModel @Inject constructor(
    private val repository: AppealRepository
) : ViewModel() {
    private val updateAppealMutableLiveData = MutableLiveData<Nothing>()
    val updateLiveData: LiveData<Nothing> = updateAppealMutableLiveData


    fun updateAppeal(appealEntity: AppealEntity) = viewModelScope.launch {
        repository.updateAppeal(appealEntity)
    }

}