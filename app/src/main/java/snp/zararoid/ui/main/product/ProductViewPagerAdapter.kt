package snp.zararoid.ui.main.product

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ProductViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = when(position) {
        0-> ProductListFragment()
        1-> ProductListFragment("coats")
        2-> ProductListFragment("puffers")
        3-> ProductListFragment("waistcoats")
        4-> ProductListFragment("trenchcoat")
        else->throw IllegalStateException("Unexpected position $position")
    }

    override fun getCount(): Int = 5
}