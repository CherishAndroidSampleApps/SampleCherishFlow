package com.sopt.samplewateringflow.dialog

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.sopt.samplewateringflow.R
import com.sopt.samplewateringflow.databinding.DialogWateringBinding
import com.sopt.samplewateringflow.databinding.FragmentDialogBinding
import com.sopt.samplewateringflow.ui.ReviewActivity

class ExplainPlantDialogFragment : DialogFragment(),
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
        val view = inflater.inflate(R.layout.dialog_watering,container,false)
        val binding = DialogWateringBinding.bind(view)

        // Round Background
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        // button Clicked
        binding.wateringPhoneCall.setOnClickListener{
            val uri = Uri.parse("tel:010-2563-9702")
            val intent = Intent(Intent.ACTION_CALL,uri)
            startActivityForResult(intent,1001)
            dismiss()
        }

        binding.wateringMessage.setOnClickListener{
            val uri = Uri.parse("smsto:010-2563-9702")
            val intent = Intent(Intent.ACTION_SENDTO,uri)
            startActivityForResult(intent,1002)
            dismiss()
        }

        binding.wateringKakao.setOnClickListener{
            Toast.makeText(requireContext(),"카카오톡을 연결해야합니다.",Toast.LENGTH_LONG).show()
        }


        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1001 -> mContext.findViewById<ConstraintLayout>(R.id.review_page).visibility = View.VISIBLE
            1002 -> mContext.findViewById<ConstraintLayout>(R.id.review_page).visibility = View.VISIBLE
            else -> {
                Toast.makeText(requireContext(),"안녕!",Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onClick(view: View?) {
        dismiss()
    }

}