package uz.gita.appealsapp.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.R
import uz.gita.appealsapp.adapter.AppealAdapter
import uz.gita.appealsapp.databinding.HistoryAppealsScreenBinding
import uz.gita.appealsapp.ui.viewmodel.HistoryAppealViewModel
import uz.gita.appealsapp.ui.viewmodel.ItemClickSensitivity
import uz.gita.appealsapp.utils.LabelWord

@AndroidEntryPoint
class HistoryAppealsScreen : Fragment(R.layout.history_appeals_screen) {
    private val binding: HistoryAppealsScreenBinding by viewBinding()
    private val viewModel: HistoryAppealViewModel by viewModels()
    private val clickItemEvent: ItemClickSensitivity by activityViewModels()
    private var adapter: AppealAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadAllowedData()
        clickEvent()

    }


    private fun loadAllowedData() {
        clickItemEvent.showNavBottom()
        adapter = AppealAdapter(LabelWord.label)
        viewModel.allAllowedLiveData.observe(viewLifecycleOwner, Observer { appealList ->
            adapter!!.differ.submitList(appealList)
        })
        binding.historyRv.adapter = adapter
        binding.historyRv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun clickEvent() {
        adapter!!.onItemClick = {
            clickItemEvent.hideNavBottom()
            findNavController().navigate(
                HistoryAppealsScreenDirections.actionHistoryAppealsScreenToInfoAppealScreen(
                    it
                )
            )
        }
    }

}