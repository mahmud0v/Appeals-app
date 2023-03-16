package uz.gita.appealsapp.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.appealsapp.adapter.AppealAdapter
import uz.gita.appealsapp.R
import uz.gita.appealsapp.databinding.NewAppealsScreenBinding
import uz.gita.appealsapp.ui.viewmodel.ItemClickSensitivity
import uz.gita.appealsapp.ui.viewmodel.NewAppealsViewModel
import uz.gita.appealsapp.utils.LabelWord

@AndroidEntryPoint
class NewAppealsScreen : Fragment(R.layout.new_appeals_screen) {
    private val binding: NewAppealsScreenBinding by viewBinding()
    private val viewModel: NewAppealsViewModel by viewModels()
    private val clickListener: ItemClickSensitivity by activityViewModels()
    private var adapter: AppealAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loadData()
        clickItem()
        checkNavBottom()

    }


    private fun loadData() {
        clickListener.showNavBottom()
        adapter = AppealAdapter(LabelWord.pendingAllowed)
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            adapter!!.differ.submitList(it)
        })

        binding.rvView.adapter = adapter
        binding.rvView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun clickItem() {
        adapter!!.onItemClick = {
            findNavController().navigate(
                NewAppealsScreenDirections.actionNewAppealsScreenToInfoAppealScreen(
                    it
                )
            )
            clickListener.hideNavBottom()

        }
    }


    private fun checkNavBottom() {
        clickListener.showNavBottom()
    }




}