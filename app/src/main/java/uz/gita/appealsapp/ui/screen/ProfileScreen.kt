package uz.gita.appealsapp.ui.screen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.R
import uz.gita.appealsapp.databinding.ProfileScreenBinding
import uz.gita.appealsapp.ui.dialog.LangListDialog

@AndroidEntryPoint
class ProfileScreen : Fragment(R.layout.profile_screen) {
    private val binding: ProfileScreenBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showDialog()
        changeSystemTheme()
    }

    private fun showDialog() {
        binding.langLayoutId.setOnClickListener {
            val dialog = LangListDialog()
            dialog.isCancelable = true
            dialog.show(requireActivity().supportFragmentManager, "dialog")
        }
    }

    private fun changeSystemTheme() {
        val sharedPreferences =
            requireContext().getSharedPreferences("mode_shared", Context.MODE_PRIVATE)
        checkSwitchMode(sharedPreferences.getString("mode_key","mode")!!)
        binding.switchId.setOnClickListener {
            if (binding.switchId.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferences.edit().putString("mode_key", "night").apply()

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferences.edit().putString("mode_key", "light").apply()

            }
        }
    }

    private fun checkSwitchMode(mode: String) {
        binding.switchId.isChecked = mode == "night"

    }

}