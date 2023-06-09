package uz.gita.appealsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.appealsapp.R
import uz.gita.appealsapp.database.AppealEntity
import uz.gita.appealsapp.utils.LabelWord

class AppealAdapter(private val labelType: String) :
    RecyclerView.Adapter<AppealAdapter.AppealViewHolder>() {

    var onItemClick: ((AppealEntity) -> Unit)? = null

    private val diffItemCallback = object : DiffUtil.ItemCallback<AppealEntity>() {

        override fun areItemsTheSame(oldItem: AppealEntity, newItem: AppealEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AppealEntity, newItem: AppealEntity) =
            oldItem == newItem

    }

    val differ = AsyncListDiffer(this, diffItemCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.appeal_item, parent, false)
        return AppealViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppealViewHolder, position: Int) {
        holder.bind(position)
    }


    override fun getItemCount() = differ.currentList.size

    inner class AppealViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int) {
            val data = differ.currentList[position]
            val phone: TextView = itemView.findViewById(R.id.phone_number_id)
            val district: TextView = itemView.findViewById(R.id.district_text)
            val requestDate: TextView = itemView.findViewById(R.id.date_id)
            val description: TextView = itemView.findViewById(R.id.desc_text)
            val detailButton: AppCompatButton = itemView.findViewById(R.id.detail_btn)
            val indexText: TextView = itemView.findViewById(R.id.appeal_index_id)
            val label: ImageView = itemView.findViewById(R.id.label_id)
            if (labelType == LabelWord.label) {
                label.setImageResource(R.drawable.bookmark)
            }
            indexText.text = "#".plus(data.id)
            phone.text = data.phoneNumber
            district.text = trimDistrict(data.districtName!!)
            requestDate.text = data.requestDate
            description.text = trimDescription(data.description!!)
            detailButton.setOnClickListener {
                onItemClick?.invoke(data)
            }


        }

        private fun trimDescription(string: String): String {
            return string.substring(0, 16).plus("...")

        }

        private fun trimDistrict(string: String): String {
            return string.substring(0, 14).plus("...")
        }

    }
}