package com.example.sampleplantenroll

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleplantenroll.databinding.ItemLayoutBinding
import kotlinx.android.synthetic.main.item_layout.view.*

data class Phone(val id:String?, val name:String?, val phone:String?

)
class PhoneBookAdapter (val list:List<Phone> ): RecyclerView.Adapter<Holder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val phone = list[position]
        holder.setPhone(phone)

    }

    override fun getItemCount(): Int {
        return list.size

    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}

@SuppressLint("MissingPermission")
class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mPhone:Phone? = null
    val chkBox  = itemView.findViewById(R.id.radioButton) as RadioButton

    init {
        itemView.btnPhone.setOnClickListener {
            mPhone?.phone.let { phoneNumber ->
                val uri = Uri.parse("tel:${phoneNumber.toString()}")
                val intent = Intent(Intent.ACTION_CALL, uri)
                itemView.context.startActivity(intent)
            }
        }

    }

    fun setPhone(phone:Phone) {
        this.mPhone = phone
        itemView.textName.text = phone.name
        itemView.textPhone.text = phone.phone
    }


}
