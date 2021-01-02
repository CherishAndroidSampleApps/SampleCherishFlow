package com.sopt.samplewateringflow.dialog

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.sopt.samplewateringflow.R
import com.sopt.samplewateringflow.databinding.DialogNeedWaterBinding
import com.sopt.samplewateringflow.databinding.FragmentDialogBinding

// 이거랑 CustomDialog는 애들하고 얘기하는게 좋을 거 같습니다.
// 다이얼로그 끝냄!!
class WateringDialogFragment(

) : DialogFragment(),
    View.OnClickListener {
    private lateinit var mContext: Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context as Activity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.dialog_need_water,container,false)
        val binding = DialogNeedWaterBinding.bind(view)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Visibility를 결정하거나 혹은 viewstub을 결정하면서 inflate시켜주면 되지 않을까?
        binding.needWaterAcceptBtn.setOnClickListener {
            val explainPlantDialogFragment =
                fragmentManager?.let { fm -> ExplainPlantDialogFragment().show(fm,"WateringDialog") }
            dismiss()
        }

        return binding.root
    }

    override fun onClick(p0: View?) {
        dismiss()
    }

    override fun onResume() {
        super.onResume()
        reSizeDialog(0.95f , 0.35f)
    }

    // 에뮬레이터 비율에 맞춰 dialog를 resize해주는 함수
    // 어느 dialog에서도 쓸 수 있는 함수
    // 만약 dialog 크기를 디자인 단에서 고정해서 준다면 그에 맞게 수치만 조정해서 함수 매개변수들 다 지워버릴 수도 있음
    private fun reSizeDialog(widthRatio : Float , heightRatio : Float){
        val params : WindowManager.LayoutParams = dialog!!.window!!.attributes
        val size = Point()
        val display = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            mContext.display
        } else {
            @Suppress("DEPRECATION")
            mContext.windowManager.defaultDisplay
        }


        display?.getRealSize(size)
        params.width = (size.x * widthRatio).toInt()
        params.height = (size.y * heightRatio).toInt()


        dialog!!.window!!.attributes = params
    }
}