package snp.zararoid.network.response

data class ZaraProductResponse(
    val data: List<ProductData>,
    val message: String,
    val status: Int,
    val success: Boolean
)

data class ProductData(
    val category: String,
    val imgUrl: String,
    val isSale: Boolean,
    val name: String,
    val originPrice: Int,
    val sale: Sale
)

data class Sale(
    val discountedPrice: Int,
    val percent: Int
)