package mening.dasturim.mymobile.ui.main.user.message.daily

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
import mening.dasturim.mymobile.databinding.ItemDailySmsBinding
import mening.dasturim.mymobile.databinding.ItemSmsBinding
import mening.dasturim.mymobile.ui.main.user.message.sms.SmsPacketsAdapter
import mening.dasturim.mymobile.utils.ViewUtils

class DailySmsAdapter (private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<DailySmsAdapter.VH>() {
    private var arrayList= listOf<NonStopItem>()

    fun setData(itemList : List<NonStopItem>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemDailySmsBinding>(inflater, R.layout.item_daily_sms,parent,false)
        return VH(binding,parent.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val isVisibile:Boolean=arrayList[position].expanded

        holder.cvExpanded.visibility = if (isVisibile){
            View.VISIBLE
        }else{
            View.GONE
        }

        holder.downBtn.setOnClickListener {
            arrayList[position].expanded = !arrayList[position].expanded
            notifyDataSetChanged()

        }

        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }

        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH(private val binding: ItemDailySmsBinding, private val context: Context)
        : RecyclerView.ViewHolder(binding.root){

        var downBtn: ConstraintLayout = binding.clArrowDown
        var cvExpanded: ConstraintLayout =binding.cvExpanded


        init {
            downBtn.setOnClickListener {
                ViewUtils.fadeOut(binding.clArrowDown)
                ViewUtils.fadeIn(binding.clArrowUp)


                binding.clArrowUp.setOnClickListener {
                    ViewUtils.fadeIn(binding.clArrowDown)
                    ViewUtils.fadeOut(binding.clArrowUp)
                }

            }
        }

        fun onBind(rate : NonStopItem){
            binding.apply {
                ivArrowDown.setImageDrawable(ContextCompat.getDrawable(context,rate.image))
                tvInterStopName.setText(rate.name)
                tvInterStopName2.setText(rate.name)
                tvInterStopAbonent.setText(rate.pay)
                tvInterStopMb.setText(rate.price)
                tvInterStopOy.setText(rate.internet)

            }
        }
    }
}