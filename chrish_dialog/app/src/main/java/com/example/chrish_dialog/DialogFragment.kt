package com.example.chrish_dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class CustomDialog : DialogFragment() {

    var title: String? = null

    var description: String? = null

    var positiveBtnText: String? = null

    var negativeBtnText: String? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_blank1, container, false)
        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        /*view?.apply {
            findViewById<TextView>(R.id.text_title)?.text = title
            findViewById<TextView>(R.id.text_description)?.text = description
            findViewById<Button>(R.id.btn_negative)?.text = negativeBtnText
            findViewById<Button>(R.id.btn_negative)?.setOnClickListener {
                dismiss()
                listener?.onClickPositiveBtn()
            }

            findViewById<Button>(R.id.btn_positive)?.text = positiveBtnText
            findViewById<Button>(R.id.btn_positive)?.setOnClickListener {
                dismiss()
                listener?.onClickNegativeBtn()
            }
        }*/
    }

    class CustomDialogBuilder {

        private val dialog = CustomDialog()

        fun setTitle(title: String): CustomDialogBuilder {
            dialog.title = title
            return this
        }

        fun setDescription(description: String): CustomDialogBuilder {
            dialog.description = description
            return this
        }

        fun setPositiveBtnText(text: String): CustomDialogBuilder {
            dialog.positiveBtnText = text
            return this
        }

        fun setNegativeBtnText(text: String): CustomDialogBuilder {
            dialog.negativeBtnText = text
            return this
        }



        fun create(): CustomDialog {
            return dialog
        }
    }
}