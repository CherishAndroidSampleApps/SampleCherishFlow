package com.sopt.samplewateringflow.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.sopt.samplewateringflow.R
import com.sopt.samplewateringflow.databinding.Test1Binding
import com.sopt.samplewateringflow.databinding.Test2Binding
import com.sopt.samplewateringflow.databinding.Test3Binding

// 이건 다시한번 고민해봐야겠다.
// 전략 패턴으로 구현할수는 있다는데 너무 비약적으로 커지는게 아닌가 싶은 마음이 듬
// Dialog 클래스 파일을 하나만 해놓는 것은 너무 이 클래스가 많은 역할을 하는 느낌이다.
// 기능을 좀 더 세분화 해서 줄일 수 있도록 하자.

// 로직이 없고 , 단순하게 lottie animation 만 보여주는 dialog 인 경우들만 사용하면 될거 같다.
// 이름은 lottieDialogFragment class라고 하면 이해하기 쉬울 것으로 예상
class CustomDialogFragment(
    @LayoutRes private val layoutResId: Int,
) : DialogFragment(),
    View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutResId, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return when (layoutResId) {
            R.layout.test_1 -> {
                val binding = Test1Binding.bind(view)
                binding.text1.text = "FuckU Text1"
                // View를 기능을 넣어준느 function
                binding.root
            }
            R.layout.test_2 -> {
                val binding = Test2Binding.bind(view)
                binding.text2.text = "FuckU Text2"
                binding.root
            }
            R.layout.test_3 -> {
                val binding = Test3Binding.bind(view)
                binding.text3.text = "FuckU Text3"
                binding.root
            }
            else -> {
                view
            }
        }
    }

    override fun onClick(p0: View?) {
        dismiss()
    }


}