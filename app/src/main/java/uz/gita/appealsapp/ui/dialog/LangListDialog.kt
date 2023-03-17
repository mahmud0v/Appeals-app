package uz.gita.appealsapp.ui.dialog

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.appealsapp.MainActivity
import uz.gita.appealsapp.R
import uz.gita.appealsapp.databinding.DialogScreenBinding
import uz.gita.appealsapp.utils.LocaleHelper

class LangListDialog : DialogFragment(R.layout.dialog_screen) {
    private val binding: DialogScreenBinding by viewBinding()
    private lateinit var lang: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeLang()
        showCheckButton(lang)
    }

    private fun changeLang() {
        val sharedPreferences = requireContext().getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        lang = sharedPreferences.getString("key","lang").toString()

        binding.uzbek.setOnClickListener {
            LocaleHelper.changeLanguage("uz", requireContext())
            showCheckButton("uz")
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        binding.russian.setOnClickListener {
            LocaleHelper.changeLanguage("ru", requireContext())
            showCheckButton("ru")
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        binding.english.setOnClickListener {
            LocaleHelper.changeLanguage("en", requireContext())
            showCheckButton("en")
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }


    }

    private fun showCheckButton(lang: String) {
        if (lang == "uz") {
            binding.checkBtn1.visibility = View.GONE
            binding.checkBtn2.visibility = View.GONE
            binding.checkBtn3.visibility = View.VISIBLE
        } else if (lang == "ru") {
            binding.checkBtn1.visibility = View.GONE
            binding.checkBtn2.visibility = View.VISIBLE
            binding.checkBtn3.visibility = View.GONE
        } else {
            binding.checkBtn1.visibility = View.VISIBLE
            binding.checkBtn2.visibility = View.GONE
            binding.checkBtn3.visibility = View.GONE
        }

    }

}