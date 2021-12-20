package mening.dasturim.mymobile.ui.main.user.rate.units

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.RateItem
import mening.dasturim.mymobile.databinding.ItemUnitsBinding
import mening.dasturim.mymobile.utils.ViewUtils

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

    class VH(private val binding: ItemUnitsBinding, private val context:Context)
        :RecyclerView.ViewHolder(binding.root){

        var downBtn:ConstraintLayout = binding.clArrowDown
        var cvExpanded:ConstraintLayout=binding.cvExpanded


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

        fun onBind(rate : RateItem){
                binding.apply {
                    ivArrowDown.setImageDrawable(ContextCompat.getDrawable(context,rate.image))
                    tvUnitsName.setText(rate.name)
                    tvUnitsName2.setText(rate.name)
                    tvUnitsAbonent.setText(rate.abonent)
                    tvUnitsLimit.setText(rate.limit)
                    tvUnitsInternet.setText(rate.internet)
                    tvUnitsMesssage.setText(rate.message)
                    tvUnitsCall.setText(rate.call)

                }
            }
        }
}