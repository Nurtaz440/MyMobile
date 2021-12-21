package mening.dasturim.mymobile.ui.main.user.internet.internet

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
import mening.dasturim.mymobile.data.module.DailyItems
import mening.dasturim.mymobile.databinding.ItemDailyStopBinding
import mening.dasturim.mymobile.databinding.ItemInternetBinding
import mening.dasturim.mymobile.ui.main.user.internet.paketlar.DailyAdapter
import mening.dasturim.mymobile.utils.ViewUtils

class InternetAdapter(private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<InternetAdapter.VH>() {
    private var arrayList= listOf<DailyItems>()

    fun setData(itemList : List<DailyItems>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemInternetBinding>(inflater, R.layout.item_internet,parent,false)
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

    class VH(private val binding: ItemInternetBinding, private val context: Context)
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

        fun onBind(rate : DailyItems){
            binding.apply {
                ivArrowDown.setImageDrawable(ContextCompat.getDrawable(context,rate.image))
                tvInternetName.setText(rate.name)
                tvInternetName2.setText(rate.name)
                tvInternetAbonent.setText(rate.abonent)
                tvInternetDeadline.setText(rate.internet)

            }
        }
    }
}