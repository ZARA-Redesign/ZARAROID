package snp.zararoid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ZaraReDesign {
    private const val BASE_URL = "http://3.36.21.222/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : ZaraService = retrofit.create(ZaraService::class.java)
}