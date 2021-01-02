package com.sopt.samplewateringflow.util

import android.app.Activity
import android.content.Context

class SoftNavigationBarSize {
    // 굳이 가지고 있을 필요없다 프로젝트에서는
    companion object{
        fun getSoftNavigationBarHeight(context : Context) : Int{
            val resources = context.resources
            val resourceId = resources.getIdentifier("navigation_bar_height","dimen","android")
            return resources.getDimensionPixelSize(resourceId)
        }
    }
}