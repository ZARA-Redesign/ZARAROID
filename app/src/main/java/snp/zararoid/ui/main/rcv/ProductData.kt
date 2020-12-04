package snp.zararoid.ui.main.rcv

data class ProductData(
    val category: Int,  // 0:all , 1:Coats, 2:Puffers, 3:WaistCoats, 4:TrenchCoat
    val imageNum: Int,
    val event: Int,  //0:New, 1:Sale, 2:Hot?ㅋㅋㅋㅋ
    val title: String,
    val sale_percent: Int,
    val org_price: Int,
    val bookmark: Boolean
)