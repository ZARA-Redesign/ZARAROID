package snp.zararoid.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import snp.zararoid.network.response.ZaraProductResponse

interface ZaraService {
    @GET("/")
    fun requestProductData(
        @Query("cate") category:String? = null?:""
    ):Call<ZaraProductResponse>


}
