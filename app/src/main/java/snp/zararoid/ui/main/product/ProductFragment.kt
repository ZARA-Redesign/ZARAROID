package snp.zararoid.ui.main.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_product.*
import snp.zararoid.R
import snp.zararoid.ui.main.product.rcv.ProductAdapter
import snp.zararoid.ui.main.product.rcv.ProductData


class ProductFragment : Fragment() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var rcvLayoutManager: GridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        productAdapter = ProductAdapter(view.context)
        rcvLayoutManager = GridLayoutManager(view.context, 2) // 한 줄에 2칸
        rcvLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            //한 줄에 아이템 2개>1개>2개>1개>... 구현할 것
            //0,1번째 아이템은 1칸씩 차지 / 2번째 아이템은 2칸 차지하면 됨.
            override fun getSpanSize(position: Int): Int {
                var gridPosition: Int = position%3
                return when(gridPosition){
                    0-> 1
                    1-> 1
                    2-> 2
                    else -> 0
                }
            }
        }

        rcv_product.apply{
            adapter = productAdapter
            layoutManager = rcvLayoutManager
        }

        productAdapter.data = mutableListOf(
            ProductData(0, R.drawable.pro_img, 0, "WOOL BLEND COAT WITH BELT", 0,219000, false),
            ProductData(0, R.drawable.pro_img, 1, "FAUX SHEARLINF COAT", 40,149000, false),
            ProductData(0, R.drawable.img, 2, "CONTRAST PUFFER JACKET", 0,109000, false),
            ProductData(0, R.drawable.pro_img, 0, "WOOL BLEND COAT WITH BELT", 0,319000, false),
            ProductData(0, R.drawable.pro_img, 1, "FAUX SHEARLINF COAT", 50,189000, false),
            ProductData(0, R.drawable.img, 2, "CONTRAST PUFFER JACKET", 0,99000, false)
        )


        //카테고리 탭 아이템 글씨체 selected : inter_bold, unselected : inter_regular
        fun changeSelectedTabItemFontFamily(tabPosition: Int, @FontRes fontFamilyRes: Int) {
            val linearLayout = (tab_product.getChildAt(0) as ViewGroup).getChildAt(tabPosition) as LinearLayout
            val tabTextView = linearLayout.getChildAt(1) as TextView
            val typeface = ResourcesCompat.getFont(view.context, fontFamilyRes)
            tabTextView.typeface = typeface
        }

        
        //탭아이템에서 디폴트로 bold 글씨체는 첫번째 아이템
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
                }

            }

        })


    }



}