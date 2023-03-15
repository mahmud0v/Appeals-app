package uz.gita.appealsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemClickSensitivity @Inject constructor() : ViewModel() {

    private val clickItemMutableLiveData = MutableLiveData<Boolean>()
    val clickItemLiveData = clickItemMutableLiveData


    fun showNavBottom() {
        clickItemMutableLiveData.value = true
    }

    fun hideNavBottom() {
        clickItemMutableLiveData.value = false
    }
}