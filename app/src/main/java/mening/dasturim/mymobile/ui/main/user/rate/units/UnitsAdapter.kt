package mening.dasturim.mymobile.ui.main.user.rate.units

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.RateItem
import mening.dasturim.mymobile.databinding.ItemUnitsBinding
import mening.dasturim.mymobile.utils.ViewUtils

class UnitsAdapter(val context: Context, private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<UnitsAdapter.VH>() {
    private var arrayList= listOf<RateItem>()
    private var colorIcon:Int = R.color.deep_sky_blue_400
    private var bgColor:Int = R.color.deep_sky_blue_100

    fun setData(itemList : List<RateItem>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }
    fun setColor(colorIcon:Int){
        this.colorIcon = colorIcon
        notifyDataSetChanged()
    }
    fun setColorLight(colorLight:Int){
        this.bgColor=colorLight
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater=LayoutInflater.from(parent.context)
        val binding =DataBindingUtil.inflate<ItemUnitsBinding>(inflater, R.layout.item_units,parent,false)
        return VH(binding,parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.ivArrowDown.setColorFilter(ContextCompat.getColor(context,colorIcon))
        holder.binding.ivArrowUp.setColorFilter(ContextCompat.getColor(context,colorIcon))
        holder.binding.mcvMain.setCardBackgroundColor(ContextCompat.getColor(context,bgColor))
        holder.binding.mbActivation.setStrokeColorResource(colorIcon)


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

    class VH( val binding: ItemUnitsBinding, val context:Context)
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