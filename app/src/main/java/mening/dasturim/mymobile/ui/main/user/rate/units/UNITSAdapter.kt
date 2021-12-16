package mening.dasturim.mymobile.ui.main.user.rate.units

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.RateItem
import mening.dasturim.mymobile.databinding.ItemUnitsBinding

class UNITSAdapter(private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<UNITSAdapter.VH>() {
    private var arrayList= listOf<RateItem>()

    fun setData(itemList : List<RateItem>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater=LayoutInflater.from(parent.context)
        val binding =DataBindingUtil.inflate<ItemUnitsBinding>(inflater, R.layout.item_units,parent,false)
        return VH(binding,parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }
        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH(private val binding: ItemUnitsBinding, private val context:Context)
        :RecyclerView.ViewHolder(binding.root){

            fun onBind(rate : RateItem){
                binding.apply {
                    ivArrowDown.setImageDrawable(ContextCompat.getDrawable(context,rate.image))
                    tvUnitsName.setText(rate.name)
                }
            }
        }
}