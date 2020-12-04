package snp.zararoid.ui.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MenuViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var fragments = listOf<Fragment>()

    override fun getItem(position: Int): Fragment = when(position) {
        0-> WomanFragment()
        1-> WomanFragment()
        2-> WomanFragment()
        else->throw IllegalStateException("Unexpected position $position")
    }
    override fun getCount(): Int = 3
}