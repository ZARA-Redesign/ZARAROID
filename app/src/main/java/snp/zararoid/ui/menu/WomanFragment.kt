package snp.zararoid.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import snp.zararoid.R


class WomanFragment : Fragment() {
    private lateinit var viewPagerAdapter: MenuViewPagerAdapter
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_woman, container, false)
    }
}