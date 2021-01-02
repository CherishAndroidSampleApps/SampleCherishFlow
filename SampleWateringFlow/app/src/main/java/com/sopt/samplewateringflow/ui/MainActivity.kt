package com.sopt.samplewateringflow.ui

import android.Manifest
import android.content.pm.PackageManager
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewStub
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.fragment.app.DialogFragment
import com.sopt.samplewateringflow.R
import com.sopt.samplewateringflow.databinding.ActivityMainBinding
import com.sopt.samplewateringflow.dialog.CustomDialogFragment
import com.sopt.samplewateringflow.dialog.ExplainPlantDialogFragment
import com.sopt.samplewateringflow.dialog.WateringDialogFragment
import com.sopt.samplewateringflow.util.SoftNavigationBarSize

class MainActivity : AppCompatActivity() {
    private val permissions = arrayOf(Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS)

    private lateinit var testPager : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkAndStart()
        testPager = findViewById(R.id.review_page)
        testPager.visibility = View.GONE
        val needWaterDialog = WateringDialogFragment().show(supportFragmentManager,"MainActivity")
    }

    private fun startProcess(){
        setContentView(R.layout.activity_main)
    }

    private fun checkAndStart() {
        if(isPermitted()){
            startProcess()
        } else {
            ActivityCompat.requestPermissions(this,permissions,99)
        }
    }

    private fun isPermitted():Boolean {
        for(perm in permissions) {
            if(checkSelfPermission(perm) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 99){
            var check = true
            for(grant in grantResults){
                if(grant != PackageManager.PERMISSION_GRANTED){
                    check = false
                    break
                }
            }
            if(check) startProcess()
            else {
                Toast.makeText(this,"권한 승인을 해야지만 앱을 사용할 수 있다.",Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}