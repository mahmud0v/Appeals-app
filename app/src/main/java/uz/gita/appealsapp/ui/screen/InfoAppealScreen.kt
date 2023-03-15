package uz.gita.appealsapp.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.R
import uz.gita.appealsapp.database.AppealEntity
import uz.gita.appealsapp.databinding.AppealInfoScreenBinding
import uz.gita.appealsapp.ui.viewmodel.InfoAppealViewModel
import uz.gita.appealsapp.ui.viewmodel.ItemClickSensitivity
import uz.gita.appealsapp.utils.LabelWord

@AndroidEntryPoint
class InfoAppealScreen : Fragment(R.layout.appeal_info_screen) {
    private val binding: AppealInfoScreenBinding by viewBinding()
    private val args: InfoAppealScreenArgs by navArgs()
    private val itemClick: ItemClickSensitivity by activityViewModels()
    private val viewModel: InfoAppealViewModel by viewModels()
    private var infoData: AppealEntity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initData()
        back()
        receiveAppeal()
    }


    private fun initData() {
        itemClick.hideNavBottom()
        infoData = args.mySafeArg
        infoData?.let {
            binding.numberText.text = it.phoneNumber
            binding.districtNameId.text = it.districtName
            binding.requestDate.text = it.requestDate
            binding.descId.text = it.description
            if (it.isAllow == 1) {
                binding.allowedTextId.text = LabelWord.allowed
            } else {
                binding.allowedTextId.text = LabelWord.pendingAllowed
            }
        }

    }

    private fun back() {

        binding.backId.setOnClickListener {
            findNavController().navigateUp()
            itemClick.showNavBottom()
        }

    }

    private fun receiveAppeal() {
        binding.allowBtn.setOnClickListener {
            if (infoData!!.isAllow != 1) {
                infoData!!.isAllow = 1
                viewModel.updateAppeal(infoData!!)
            }

        }
    }


}