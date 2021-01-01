package com.example.chrish_dialog

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val items=ArrayList<Fragment>()

    init{
        items.add(DialogFragment())
        items.add(BlankFragment2())
        //items.add(BlankFragment1())
    }
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }
}