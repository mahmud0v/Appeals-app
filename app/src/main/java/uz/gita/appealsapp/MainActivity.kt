package uz.gita.appealsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.databinding.ActivityMainBinding
import uz.gita.appealsapp.ui.viewmodel.ItemClickSensitivity

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




    private fun showNavBottom() {
        binding.botNavView.visibility = View.VISIBLE
    }

    private fun hideNavBottom() {
        binding.botNavView.visibility = View.GONE
    }


}