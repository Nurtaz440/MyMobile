package mening.dasturim.mymobile.ui.main.user.internet.paketlar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.mymobile.R
import mening.dasturim.mymobile.data.module.InternetItems
import mening.dasturim.mymobile.databinding.ItemInternetBinding
import mening.dasturim.mymobile.utils.ViewUtils

class DailyAdapter(val context:Context,private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<DailyAdapter.VH>() {
    private var arrayList= listOf<InternetItems>()
    private var colorIcon:Int=R.color.deep_sky_blue_400
    private var bgColor:Int=R.color.deep_sky_blue_100

    fun setData(itemList : List<InternetItems>){
        this.arrayList=itemList
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemInternetBinding>(inflater, R.layout.item_internet,parent,false)
        return VH(binding,parent.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: VH, position: Int) {
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
        holder.binding.mbActivation.setOnClickListener {
            itemClickListener.invoke(position)
        }

        holder.cvOpen.setOnClickListener {
            arrayList[position].expanded = !arrayList[position].expanded
            notifyDataSetChanged()
        }
        holder.tvDetails.setOnClickListener {
            val uriUrl: Uri = Uri.parse(arrayList[position].details)
            val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
            ContextCompat.startActivity(context, launchBrowser, null)
        }
        if (arrayList[position].min_payment!!.isNotEmpty()) {
            ViewUtils.fadeIn(holder.binding.rl4)
        } else {
            ViewUtils.fadeOut(holder.binding.rl4)
        }

        if (arrayList[position].max_internet!!.isNotEmpty()) {
            ViewUtils.fadeIn(holder.binding.rl3)
        } else {
            ViewUtils.fadeOut(holder.binding.rl3)
        }

        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH( val binding: ItemInternetBinding, private val context: Context)
        : RecyclerView.ViewHolder(binding.root){

        var downBtn: ConstraintLayout = binding.clArrowDown
        var cvExpanded: ConstraintLayout =binding.cvExpanded
        var cvOpen: CardView =binding.cvOpen
        var tvDetails: TextView =binding.tvDetails

        init {
            downBtn.setOnClickListener {
                ViewUtils.fadeOut(binding.clArrowDown)
                ViewUtils.fadeIn(binding.clArrowUp)


                binding.clArrowUp.setOnClickListener {
                    ViewUtils.fadeIn(binding.clArrowDown)
                    ViewUtils.fadeOut(binding.clArrowUp)
                }

            }

            val content = SpannableString("Batafsil")
            content.setSpan(UnderlineSpan(), 0, content.length, 0)
            binding.tvDetails.setText(content)
        }

        fun onBind(rate : InternetItems){
            binding.apply {
                tvTasixName.setText(rate.name)
                tvTasixName2.setText(rate.name)
                tvAbonent.setText(rate.payment)
                tvInternet.setText(rate.internet)
                tvInternetOut.setText(rate.min_payment)
                tvCashback.setText(rate.max_internet)
                tvExpire.setText(rate.expire)
            }
        }
    }
}