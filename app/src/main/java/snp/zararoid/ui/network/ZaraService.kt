package snp.zararoid.ui.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ZaraService {
    @Headers("Content-Type:application/json")
    @GET("/")
    fun getProductData(
        @Query("cate") cate: String? = null?:""
    ) : Call<ProductListResponseData>

}
