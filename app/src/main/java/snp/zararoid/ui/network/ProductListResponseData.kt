package snp.zararoid.ui.network

data class ProductListResponseData(
    val data: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
){
    data class Data(
        val category: String,
        val imgUrl: String,
        val isSale: Boolean,
        val name: String,
        val originPrice: Int,
        val sale: Sale
    ){
        data class Sale(
            val discountedPrice: Int,
            val percent: Int
        )
    }

}