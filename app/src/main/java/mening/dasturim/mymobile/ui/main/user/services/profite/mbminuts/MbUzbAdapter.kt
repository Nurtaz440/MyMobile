package mening.dasturim.mymobile.ui.main.user.services.profite.mbminuts

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
import mening.dasturim.mymobile.data.module.ServiceItmes
import mening.dasturim.mymobile.databinding.ItemServicesBinding
import mening.dasturim.mymobile.utils.ViewUtils

class MbUzbAdapter( val context: Context, private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MbUzbAdapter.VH>() {
    private var arrayList= listOf<ServiceItmes>()
    private var colorIcon:Int=R.color.deep_sky_blue_400
    private var bgColor:Int=R.color.deep_sky_blue_100

    fun setData(list:List<ServiceItmes>){
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ItemServicesBinding>(
            inflater,
            R.layout.item_services,
            parent,
            false
        )
        return VH(binding,parent.context)

    }

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
        if (arrayList[position].code!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.mbActivation)
            holder.binding.mbActivation.setOnClickListener {
                itemClickListener.invoke(position)
            }
        }else{
            ViewUtils.fadeOut(holder.binding.mbActivation)
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
        if (arrayList[position].number!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl)
        }else{
            ViewUtils.fadeOut(holder.binding.rl)
        }
        if (arrayList[position].payment2!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl2)
        }else{
            ViewUtils.fadeOut(holder.binding.rl2)
        }
        if (arrayList[position].internet!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl3)
        }else{
            ViewUtils.fadeOut(holder.binding.rl3)
        }
        if (arrayList[position].activation!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl4)
        }else{
            ViewUtils.fadeOut(holder.binding.rl4)
        }
        if (arrayList[position].free_sms!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl5)
        }else{
            ViewUtils.fadeOut(holder.binding.rl5)
        }
        if (arrayList[position].score!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl6)
        }else{
            ViewUtils.fadeOut(holder.binding.rl6)
        }
        if (arrayList[position].call_in!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl7)
        }else{
            ViewUtils.fadeOut(holder.binding.rl7)
        }
        if (arrayList[position].call_out!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl8)
        }else{
            ViewUtils.fadeOut(holder.binding.rl8)
        }
        if (arrayList[position].call_uzb!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl9)
        }else{
            ViewUtils.fadeOut(holder.binding.rl9)
        }
        if (arrayList[position].sms!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl10)
        }else{
            ViewUtils.fadeOut(holder.binding.rl10)
        }
        if (arrayList[position].speed!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl11)
        }else{
            ViewUtils.fadeOut(holder.binding.rl11)
        }
        if (arrayList[position].messager!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl12)
        }else{
            ViewUtils.fadeOut(holder.binding.rl12)
        }
        if (arrayList[position].sputnik!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl13)
        }else{
            ViewUtils.fadeOut(holder.binding.rl13)
        }
        if (arrayList[position].payment_question!!.isNotEmpty()){
            ViewUtils.fadeIn(holder.binding.rl14)
        }else{
            ViewUtils.fadeOut(holder.binding.rl14)
        }
        holder.onBind(arrayList[position])
    }


    override fun getItemCount()=arrayList.size

    class VH(val binding: ItemServicesBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

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

        fun onBind(rate : ServiceItmes){
            binding.apply {
                tvInterStopName.setText(rate.name)
                tvInterStopName2.setText(rate.name)
                tvAbonent.setText(rate.payment)
                tvExpire.setText(rate.expire)
                tvNumber.setText(rate.number)
                tvPayment.setText(rate.payment2)
                tvInternet.setText(rate.internet)
                tvActivation.setText(rate.activation)
                tvCallIn.setText(rate.call_in)
                tvCallOut.setText(rate.call_out)
                tvCallUzb.setText(rate.call_uzb)
                tvSms.setText(rate.sms)
                tvSpeed.setText(rate.speed)
                tvSputnik.setText(rate.sputnik)
                tvMessanger.setText(rate.messager)
                tvPaymentQuestion.setText(rate.payment_question)
                tvScore.setText(rate.score)
                tvFreeSms.setText(rate.free_sms)
                tvNumber.isSelected = true
            }
        }
    }
}