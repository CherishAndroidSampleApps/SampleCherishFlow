package com.example.sampleplantenroll

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.example.sampleplantenroll.databinding.AcitivityEnrollplantBinding
import com.example.sampleplantenroll.databinding.ActivityPhonebookBinding

class EnrollPlantActicity :AppCompatActivity() {

    private lateinit var binding: AcitivityEnrollplantBinding
    private lateinit var progressDialog: AppCompatDialog
    private val time: Long =500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= AcitivityEnrollplantBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.detailOkBtn.setOnClickListener {
            progressON()
            Handler().postDelayed({
                // This method will be executed once the timer is over
                // Start your app main activity

                //startActivity(Intent(this, MainActivity::class.java))
                progressOFF()
                // close this activity
                finish()
            }, time)


            val intent= Intent(this,ResultPlantActivity::class.java)

            intent.putExtra("plantkey",  binding.editweek.text.toString())
            startActivity(intent)

        }


    }

    fun progressON(){
        progressDialog = AppCompatDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setContentView(R.layout.progress_layout)
        progressDialog.show()
        /*var img_loading_framge = progressDialog.findViewById<ImageView>(R.id.GIFimage)
        var frameAnimation = img_loading_framge?.getBackground() as AnimationDrawable
        img_loading_framge?.post(object : Runnable{
            override fun run() {
                frameAnimation.start()
            }

        })*/
    }
    fun progressOFF(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss()
        }
    }
}