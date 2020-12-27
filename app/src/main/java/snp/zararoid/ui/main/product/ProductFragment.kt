package snp.zararoid.ui.main.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_product.*
import snp.zararoid.R
import snp.zararoid.ui.main.MainActivity


class ProductFragment : Fragment() {
    private lateinit var productViewPagerAdapter: ProductViewPagerAdapter
    private var param1: Int? = null
    private var activity: MainActivity = MainActivity()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        productViewPagerAdapter = ProductViewPagerAdapter(childFragmentManager)

        rcv_viewpager.adapter = productViewPagerAdapter

        tab_product.setupWithViewPager(rcv_viewpager)
        tab_product.apply{
            getTabAt(0)?.text = "VIEW ALL"
            getTabAt(1)?.text = "COATS"
            getTabAt(2)?.text = "PUFFERS"
            getTabAt(3)?.text = "WAISTCOATS"
            getTabAt(4)?.text = "TRENCH COAT"
        }

        //카테고리 탭 아이템 글씨체 selected : inter_bold, unselected : inter_regular
        fun changeSelectedTabItemFontFamily(tabPosition: Int, @FontRes fontFamilyRes: Int) {
            val linearLayout = (tab_product.getChildAt(0) as ViewGroup).getChildAt(tabPosition) as LinearLayout
            val tabTextView = linearLayout.getChildAt(1) as TextView
            val typeface = ResourcesCompat.getFont(view.context, fontFamilyRes)
            tabTextView.typeface = typeface
        }

        
        //탭아이템에서 디폴트로 bold글씨체는 첫번째 아이템
        changeSelectedTabItemFontFamily(0, R.font.inter_bold)

        tab_product.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.position?.let {
                    changeSelectedTabItemFontFamily(it, R.font.inter_regular)
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let {
                    changeSelectedTabItemFontFamily(it, R.font.inter_bold)
                    // Key, Value fragment.setArguments(bundle);

                }
            }

        })


    }
}