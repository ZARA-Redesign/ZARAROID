package snp.zararoid.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import snp.zararoid.ui.menu.ProductFragment

class MainViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = when(position) {
        0-> ProductFragment()
        else->throw IllegalStateException("Unexpected position $position")

    }

    override fun getCount(): Int = 1
}