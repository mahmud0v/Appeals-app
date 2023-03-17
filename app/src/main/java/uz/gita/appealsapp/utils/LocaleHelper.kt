package uz.gita.appealsapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.preference.PreferenceManager
import java.util.Locale

class LocaleHelper {

    companion object {

        fun changeLanguage(lang: String, context: Context) {
            val locale = Locale(lang)
            Locale.setDefault(locale)
            val config = Configuration()
            config.setLocale(locale)
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
            saveLang(context, lang)
        }

        private fun saveLang(context: Context, lang: String) {
            val sharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("key", lang).apply()
        }


    }


}