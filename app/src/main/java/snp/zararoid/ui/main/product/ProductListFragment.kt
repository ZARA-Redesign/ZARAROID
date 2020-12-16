package snp.zararoid.ui.main.product

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_product_list.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snp.zararoid.R
import snp.zararoid.ui.main.product.rcv.ProductAdapter
import snp.zararoid.ui.main.product.rcv.ProductData
import snp.zararoid.ui.network.ProductListResponseData
import snp.zararoid.ui.network.ZaraReDesign


class ProductListFragment : Fragment() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var rcvLayoutManager: GridLayoutManager
    private var category: String = ""
    private var rcvProductListData = mutableListOf<ProductData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productAdapter = ProductAdapter(view.context)
        rcvLayoutManager = GridLayoutManager(view.context, 2) // 한 줄에 2칸
        rcvLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            //한 줄에 아이템 2개>1개>2개>1개>... 구현할 것
            //0,1번째 아이템은 1칸씩 차지 / 2번째 아이템은 2칸 차지하면 됨.
            override fun getSpanSize(position: Int): Int {
                var gridPosition: Int = position%3
                return when(gridPosition){
                    0 -> 1
                    1 -> 1
                    2 -> 2
                    else -> 0
                }
            }
        }

        rcv_product.apply{
            adapter = productAdapter
            layoutManager = rcvLayoutManager
        }

        val call: Call<ProductListResponseData> = ZaraReDesign.service.getProductData(cate = category)
        call.enqueue(object : Callback<ProductListResponseData> {
            override fun onFailure(call: Call<ProductListResponseData>, t: Throwable) {
                //통신 실패 로직
            }

            override fun onResponse(
                call: Call<ProductListResponseData>,
                response: Response<ProductListResponseData>
            ) {
                response.takeIf { it.isSuccessful }
                    ?.body()
                    ?.let { data ->
                        for (i in 0 until data.data.size) {
                            rcvProductListData.add(
                                ProductData(
                                    data.data[i].imgUrl,
                                    data.data[i].isSale,
                                    data.data[i].name,
                                    data.data[i].sale.percent,
                                    data.data[i].originPrice,
                                    false
                                )
                            )
                        }
                        productAdapter.data = rcvProductListData
                        //Adapter에 데이터가 갱신되었다고 알려주기!
                        productAdapter.notifyDataSetChanged()
                        Toast.makeText(view.context, category, Toast.LENGTH_SHORT).show()
                    } ?: showError(response.errorBody())
            }

            private fun showError(error: ResponseBody?) {
                val e = error ?: return
                val ob = JSONObject(e.string())
                Toast.makeText(view.context, ob.getString("message"), Toast.LENGTH_SHORT).show()
            }
        })

//        productAdapter.data = mutableListOf(
//            ProductData(0, R.drawable.pro_img, 0, "WOOL BLEND COAT WITH BELT", 0,219000, false),
//            ProductData(0, R.drawable.pro_img, 1, "FAUX SHEARLINF COAT", 40,149000, false),
//            ProductData(0, R.drawable.img, 2, "CONTRAST PUFFER JACKET", 0,109000, false),
//            ProductData(0, R.drawable.pro_img, 0, "WOOL BLEND COAT WITH BELT", 0,319000, false),
//            ProductData(0, R.drawable.pro_img, 1, "FAUX SHEARLINF COAT", 50,189000, false),
//            ProductData(0, R.drawable.img, 2, "CONTRAST PUFFER JACKET", 0,99000, false)
//        )

    }

    fun receiveCategoryValue(categoryData: String){
        category = categoryData
        Log.d("pass","ProductList " + category)
    }

}