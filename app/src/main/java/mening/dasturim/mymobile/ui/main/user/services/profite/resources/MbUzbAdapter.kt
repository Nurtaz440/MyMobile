package mening.dasturim.mymobile.ui.main.user.services.profite.resources

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
import mening.dasturim.mymobile.databinding.ItemTasixBinding
import mening.dasturim.mymobile.utils.ViewUtils

class MbUzbAdapter( val context: Context, private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MbUzbAdapter.VH>() {
    private var arrayList= listOf<DailyItems>()
    private var colorIcon:Int=R.color.deep_sky_blue_400
    private var bgColor:Int=R.color.deep_sky_blue_100

    fun setData(list:List<DailyItems>){
        this.arrayList=list
        notifyDataSetChanged()
    }
    fun setColor(colorList:Int){
        this.colorIcon=colorList
        notifyDataSetChanged()
    }
    fun setColorLight(color:Int){
        this.bgColor=color
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MbUzbAdapter.VH {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ItemTasixBinding>(
            inflater,
            R.layout.item_tasix,
            parent,
            false
        )
        return VH(binding,parent.context)

    }

    override fun onBindViewHolder(holder: MbUzbAdapter.VH, position: Int) {
        holder.binding.ivArrowUp.setColorFilter(ContextCompat.getColor(context,colorIcon))
        holder.binding.ivArrowDown.setColorFilter(ContextCompat.getColor(context,colorIcon))
        holder.binding.mbActivation.setStrokeColorResource(colorIcon)
        holder.binding.mcvMain.setCardBackgroundColor(ContextCompat.getColor(context,bgColor))

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

    class VH(val binding: ItemTasixBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

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
                tvTasixName.setText(rate.name)
                tvTasixName2.setText(rate.name)
                tvTasixDeadline.setText(rate.internet)

            }
        }
    }
}