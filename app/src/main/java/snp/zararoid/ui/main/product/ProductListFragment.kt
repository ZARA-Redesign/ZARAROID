package snp.zararoid.ui.main.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_product_list.*
import snp.zararoid.R
import snp.zararoid.network.ZaraReDesign
import snp.zararoid.network.response.ZaraProductResponse
import snp.zararoid.network.response.customEnqueue
import snp.zararoid.ui.main.product.rcv.ProductAdapter

class ProductListFragment(private val category: String? = null) : Fragment() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var rcvLayoutManager: GridLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        productAdapter = ProductAdapter()
        rcvLayoutManager = GridLayoutManager(view.context, 2) // 한 줄에 2칸
        rcvLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            //한 줄에 아이템 2개>1개>2개>1개>... 구현할 것
            //0,1번째 아이템은 1칸씩 차지 / 2번째 아이템은 2칸 차지하면 됨.
            override fun getSpanSize(position: Int): Int {
                var gridPosition: Int = position % 3
                return when (gridPosition) {
                    0 -> 1
                    1 -> 1
                    2 -> 2
                    else -> 0
                }
            }
        }

        rcv_product.apply {
            adapter = productAdapter
            layoutManager = rcvLayoutManager
        }

        requestToProductData()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun requestToProductData() {
        ZaraReDesign.service
            .requestProductData(category = this.category)
            .customEnqueue(
                onSuccess = { onSuccessResponseEvent(it) }
            )
    }

    private fun onSuccessResponseEvent(zaraProductResponse: ZaraProductResponse) {
        productAdapter.data.addAll(zaraProductResponse.data)
        productAdapter.notifyDataSetChanged()
    }
}