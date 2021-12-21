package mening.dasturim.mymobile.ui.main.user.ussd

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.NonStopItem
import mening.dasturim.mymobile.data.module.USSDItems
import mening.dasturim.mymobile.databinding.ItemInternationalBinding
import mening.dasturim.mymobile.databinding.ItemUssdBinding
import mening.dasturim.mymobile.ui.main.user.message.around.InternationalAdapter
import mening.dasturim.mymobile.utils.ViewUtils

class USSDAdapter  (private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<USSDAdapter.VH>() {
    private var arrayList= listOf<USSDItems>()

    fun setData(itemList : List<USSDItems>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemUssdBinding>(inflater, R.layout.item_ussd,parent,false)
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

    class VH(private val binding: ItemUssdBinding, private val context: Context)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(rate : USSDItems){
            binding.apply {
                tvUssd.setText(rate.name)
                tvUssdDescribe.setText(rate.abonent)

            }
        }
    }
}