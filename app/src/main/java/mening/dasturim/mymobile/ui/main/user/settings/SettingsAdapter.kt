package mening.dasturim.mymobile.ui.main.user.settings

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.SettingsItems
import mening.dasturim.mymobile.databinding.ItemSettingsBinding

class SettingsAdapter (private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<SettingsAdapter.VH>() {
    private var arrayList= listOf<SettingsItems>()

    fun setData(itemList : List<SettingsItems>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemSettingsBinding>(inflater, R.layout.item_settings,parent,false)
        return VH(binding,parent.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }

        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH(private val binding: ItemSettingsBinding, private val context: Context)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(rate : SettingsItems){
            binding.apply {
                tvInterStopName.setText(rate.name)
            }
        }
    }
}