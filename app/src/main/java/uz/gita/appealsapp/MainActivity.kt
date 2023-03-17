package uz.gita.appealsapp

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.databinding.ActivityMainBinding
import uz.gita.appealsapp.ui.viewmodel.ItemClickSensitivity
import uz.gita.appealsapp.utils.LocaleHelper
import java.util.Locale

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: ItemClickSensitivity by viewModels()
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachBotNav()
        listenItemClickAction()
        showLangEvent()
        checkSystemMode()
        btnCheckItemLang()


    }

    private fun attachBotNav() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.botNavView.setupWithNavController(navHostFragment.navController)
    }

    private fun listenItemClickAction() {
        viewModel.clickItemLiveData.observe(this, Observer {
            if (it) {
                showNavBottom()
            } else {
                hideNavBottom()
            }
        })
    }

    private fun showLangEvent() {
        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val lang = sharedPreferences.getString("key", "lang")
        LocaleHelper.changeLanguage(lang!!, this)
    }


    private fun showNavBottom() {
        binding.botNavView.visibility = View.VISIBLE
    }

    private fun hideNavBottom() {
        binding.botNavView.visibility = View.GONE
    }

    private fun checkSystemMode() {
        val sharedPreferences = getSharedPreferences("mode_shared", Context.MODE_PRIVATE)
        val mode = sharedPreferences.getString("mode_key", "mode")
        if (mode == "night") {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

    }

    private fun btnCheckItemLang(){
        binding.botNavView.menu.apply {
            findItem(R.id.newAppealsScreen).title = resources.getString(R.string.new_appeal_icon_title)
            findItem(R.id.historyAppealsScreen).title = resources.getString(R.string.history_appeal_icon_title)
            findItem(R.id.profileScreen).title = resources.getString(R.string.profile_icon_title)
        }
    }



}