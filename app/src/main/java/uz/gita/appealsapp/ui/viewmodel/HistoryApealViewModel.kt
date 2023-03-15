package uz.gita.appealsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.appealsapp.database.AppealEntity
import uz.gita.appealsapp.repository.AppealRepository
import javax.inject.Inject

@HiltViewModel
class HistoryAppealViewModel @Inject constructor(
    private val repository: AppealRepository
) : ViewModel() {
    private val allAllowedMutableLiveData = MutableLiveData<List<AppealEntity>>()
    val allAllowedLiveData = allAllowedMutableLiveData

    init {
        getAllAllowed()
    }

    private fun getAllAllowed() = viewModelScope.launch {
        repository.getAllowedAppeals().collect {
            allAllowedMutableLiveData.value = it
        }
    }



}