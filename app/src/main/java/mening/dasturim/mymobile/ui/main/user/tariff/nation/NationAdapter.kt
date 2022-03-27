package mening.dasturim.mymobile.ui.main.user.tariff.nation

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
import mening.dasturim.mymobile.data.module.TariffItems
import mening.dasturim.mymobile.databinding.ItemTariffBinding
import mening.dasturim.mymobile.utils.ViewUtils

class NationAdapter(val context:Context,private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<NationAdapter.VH>() {
    private var arrayList= listOf<TariffItems>()
    private var colorIcon:Int=R.color.deep_sky_blue_400
    private var bgColor:Int=R.color.deep_sky_blue_100

    @SuppressLint("NotifyDataSetChanged")
    fun setData(itemList : List<TariffItems>){
        this.arrayList=itemList
        notifyDataSetChanged()
    }
    fun setColor(colorIconList:Int){
        this.colorIcon=colorIconList
    }
    fun setColorLight(color:Int){
        this.bgColor= color
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater= LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemTariffBinding>(inflater, R.layout.item_tariff,parent,false)
        return VH(binding,parent.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.ivArrowDown.setColorFilter(ContextCompat.getColor(context,colorIcon))
        holder.binding.ivArrowUp.setColorFilter(ContextCompat.getColor(context,colorIcon))
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
        if (arrayList[position].callout!!.isNotEmpty() &&
            arrayList[position].sms_out!!.isNotEmpty() &&
            arrayList[position].internet_out!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl)
            ViewUtils.fadeIn(holder.binding.rl2)
            ViewUtils.fadeIn(holder.binding.rl3)
        }else if (arrayList[position].callout!!.isNotEmpty()  &&
            !arrayList[position].sms_out!!.isNotEmpty()  &&
            !arrayList[position].internet_out!!.isNotEmpty() ){
            ViewUtils.fadeIn(holder.binding.rl)
            ViewUtils.fadeOut(holder.binding.rl2)
            ViewUtils.fadeOut(holder.binding.rl3)
        }else if (!arrayList[position].sms_out!!.isNotEmpty() &&
            arrayList[position].callout!!.isNotEmpty()  &&
            !arrayList[position].internet_out!!.isNotEmpty()){
            ViewUtils.fadeOut(holder.binding.rl)
            ViewUtils.fadeIn(holder.binding.rl2)
            ViewUtils.fadeOut(holder.binding.rl3)
        }else if (!arrayList[position].sms_out!!.isNotEmpty() &&
            !arrayList[position].callout!!.isNotEmpty()  &&
            arrayList[position].internet_out!!.isNotEmpty()){
            ViewUtils.fadeOut(holder.binding.rl)
            ViewUtils.fadeOut(holder.binding.rl2)
            ViewUtils.fadeIn(holder.binding.rl3)
        }else if (arrayList[position].sms_out!!.isNotEmpty() &&
            arrayList[position].callout!!.isNotEmpty()  &&
            !arrayList[position].internet_out!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl)
            ViewUtils.fadeIn(holder.binding.rl2)
            ViewUtils.fadeOut(holder.binding.rl3)
        }else if (arrayList[position].sms_out!!.isNotEmpty() &&
            !arrayList[position].callout!!.isNotEmpty()  &&
            arrayList[position].internet_out!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl)
            ViewUtils.fadeOut(holder.binding.rl2)
            ViewUtils.fadeIn(holder.binding.rl3)
        }else if (!arrayList[position].sms_out!!.isNotEmpty() &&
            arrayList[position].callout!!.isNotEmpty()  &&
            arrayList[position].internet_out!!.isNotEmpty()){
            ViewUtils.fadeOut(holder.binding.rl)
            ViewUtils.fadeIn(holder.binding.rl2)
            ViewUtils.fadeIn(holder.binding.rl3)
        }else{
            ViewUtils.fadeOut(holder.binding.rl)
            ViewUtils.fadeOut(holder.binding.rl2)
            ViewUtils.fadeOut(holder.binding.rl3)
        }
        if (arrayList[position].cashback!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl4)
        }else{
            ViewUtils.fadeOut(holder.binding.rl4)
        }
        holder.onBind(arrayList[position])
    }

    override fun getItemCount()=arrayList.size

    class VH(val binding: ItemTariffBinding, private val context: Context)
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

        fun onBind(tariff : TariffItems){
            binding.apply {
                tvUnitsName.setText(tariff.name)
                tvUnitsName2.setText(tariff.name)
                tvAbonent.setText(tariff.payment)
                tvInternet.setText(tariff.internet)
                tvInternetOut.setText(tariff.internet_out)
                tvSms.setText(tariff.sms)
                tvCall.setText(tariff.call)
                tvCallOut.setText(tariff.callout)
                tvSmsOut.setText(tariff.sms_out)
                tvCashback.setText(tariff.cashback)
                tvExpire.setText(tariff.expire)
            }
        }
    }
}