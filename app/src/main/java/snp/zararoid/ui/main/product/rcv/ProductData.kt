package snp.zararoid.ui.main.product.rcv

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductData(
    //val category: Int,  // 0:all , 1:Coats, 2:Puffers, 3:WaistCoats, 4:TrenchCoat
    val imageUrl: String,
    val isSale: Boolean,  //0:New, 1:Sale
    val title: String,
    val sale_percent: Int,
    val org_price: Int,
    val bookmark: Boolean
): Parcelable