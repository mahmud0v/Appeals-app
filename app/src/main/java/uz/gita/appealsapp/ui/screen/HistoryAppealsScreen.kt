package uz.gita.appealsapp.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.R
import uz.gita.appealsapp.adapter.AppealAdapter
import uz.gita.appealsapp.databinding.HistoryAppealsScreenBinding
import uz.gita.appealsapp.ui.viewmodel.HistoryAppealViewModel
import uz.gita.appealsapp.utils.LabelWord

@AndroidEntryPoint
class HistoryAppealsScreen : Fragment(R.layout.history_appeals_screen) {
    private val binding: HistoryAppealsScreenBinding by viewBinding()
    private val viewModel: HistoryAppealViewModel by viewModels()
    private var adapter: AppealAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadAllowedData()

    }


    private fun loadAllowedData() {
        adapter = AppealAdapter(LabelWord.label)
        viewModel.allAllowedLiveData.observe(viewLifecycleOwner, Observer { appealList ->
            Toast.makeText(requireContext(),"${appealList.size}",Toast.LENGTH_SHORT).show()
            adapter!!.differ.submitList(appealList)
        })
        binding.historyRv.adapter = adapter
        binding.historyRv.layoutManager = LinearLayoutManager(requireContext())
    }

}