package uz.gita.appealsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.gita.appealsapp.database.AppealEntity
import uz.gita.appealsapp.repository.AppealRepository
import javax.inject.Inject

@HiltViewModel
class NewAppealsViewModel @Inject constructor(
    private val appealRepository: AppealRepository
) : ViewModel() {

    private val allAppealsMutableLiveData = MutableLiveData<List<AppealEntity>>()
    val liveData: LiveData<List<AppealEntity>> = allAppealsMutableLiveData

    init {
        getAllAppeals()
    }

    private fun getAllAppeals() = viewModelScope.launch {
        appealRepository.getAllRepository().collect {
            allAppealsMutableLiveData.value = it
        }
    }


}