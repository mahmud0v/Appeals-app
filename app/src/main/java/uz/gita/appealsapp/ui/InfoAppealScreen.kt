package uz.gita.appealsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.R
import uz.gita.appealsapp.databinding.AppealInfoScreenBinding
import uz.gita.appealsapp.ui.viewmodel.ItemClickSensitivity

@AndroidEntryPoint
class InfoAppealScreen : Fragment(R.layout.appeal_info_screen) {
    private val binding: AppealInfoScreenBinding by viewBinding()
    private val args: InfoAppealScreenArgs by navArgs()
    private val viewModel: ItemClickSensitivity by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initData()
        back()
    }


    private fun initData() {
        viewModel.hideNavBottom()
        val data = args.mySafeArg
        binding.numberText.text = data.phoneNumber
        binding.districtNameId.text = data.districtName
        binding.requestDate.text = data.requestDate
        binding.descId.text = data.description
    }

    private fun back(){

        binding.backId.setOnClickListener {
            findNavController().navigateUp()
            viewModel.showNavBottom()
        }

    }




}