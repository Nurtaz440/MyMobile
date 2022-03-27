package mening.dasturim.mymobile.ui.main.user.connect

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.UssdItems
import mening.dasturim.mymobile.databinding.ItemUssdBinding


class ConnectAdapter ( val context: Context, private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<ConnectAdapter.VH>() {
    private var arrayList= listOf<UssdItems>()
    private var colorLight:Int=R.color.deep_sky_blue_100

    fun setData(itemList : List<UssdItems>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }
    fun setColorLight(bgColorList:Int){
        this.colorLight=bgColorList
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
        holder.binding.tvUssd.setBackgroundColor(ContextCompat.getColor(context,colorLight))

        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }

        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH( val binding: ItemUssdBinding, private val context: Context)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(rate : UssdItems){
            binding.apply {
                tvUssd.setText(rate.name!!)
                tvUssdDescribe.setText(rate.details!!)

            }
        }
    }
}