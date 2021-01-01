package com.example.chrish_dialog

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.chrish_dialog.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)

        button.setOnClickListener {
            val intent= Intent(this,DialogActivity::class.java)
            startActivity(intent)

            /*val dialog = AlertDialog.Builder(this).create()
            val edialog: LayoutInflater = LayoutInflater.from(this)
            val mView: View = edialog.inflate(R.layout.namechange, null)
            val close: Button = mView.findViewById(R.id.close_btn)
            close.setOnClickListener {
                dialog.dismiss()
                dialog.cancel()
            }

            val color = ColorDrawable(Color.TRANSPARENT)
            // Dialog 크기 설정
            val inset = InsetDrawable(color, 85)
            dialog.window?.setBackgroundDrawable(inset)
            dialog.setCancelable(false)
            dialog.setView(mView)
            // dialog.create()
            dialog.show()
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)*/
        }


        // 탭 레아아웃에 뷰페이저 연결

    }
}