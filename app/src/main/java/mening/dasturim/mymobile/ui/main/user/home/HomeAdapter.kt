package mening.dasturim.mymobile.ui.main.user.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.HomeItems
import mening.dasturim.mymobile.databinding.ItemHomeBinding

class HomeAdapter (val context: Context, private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.VH>() {
    private var arrayList= listOf<HomeItems>()
    private var colorItem:Int= R.color.deep_sky_blue_400

    fun setData(itemList : List<HomeItems>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }
    fun setColor(bgColorList:Int){
        this.colorItem=bgColorList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemHomeBinding>(inflater, R.layout.item_home,parent,false)
        return VH(binding,parent.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.ivTariflar.setColorFilter(ContextCompat.getColor(context,colorItem))

        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }

        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH(val binding: ItemHomeBinding, private val context: Context)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(home : HomeItems){
            binding.apply {
                ivTariflar.setImageDrawable(ContextCompat.getDrawable(context,home.image))
                tvTariflar.setText(home.name)

            }
        }
    }
}