package snp.zararoid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_product.*
import snp.zararoid.rcv.ProductAdapter
import snp.zararoid.rcv.ProductData


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



    }



}