package snp.zararoid.ui.main.product.rcv

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import snp.zararoid.R
import snp.zararoid.network.response.ProductData
import snp.zararoid.network.response.Sale
import java.text.DecimalFormat

class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    private val event: TextView = itemView.findViewById(R.id.txt_event)
    private val title: TextView = itemView.findViewById(R.id.txt_title)
    private val org_price: TextView = itemView.findViewById(R.id.txt_original_price)
    private val sale_price: TextView = itemView.findViewById(R.id.txt_sale_price)
    private val imageNum: ImageView = itemView.findViewById(R.id.img_product)
    val formatPrice = DecimalFormat("#,###,###") //천단위마다 , 추가

    fun onBind(data: ProductData) {
        if (data.isSale) onSaleDataBind(data.sale) else event.text = "NEW"
        title.text = data.name
        org_price.text = "${formatPrice.format(data.originPrice)}원"
        Glide.with(itemView)
            .load(data.imgUrl)
            .into(imageNum)
    }

    private fun onSaleDataBind(sale: Sale) {
        event.text = "${sale.percent}%OFF"
        org_price.paintFlags = org_price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        sale_price.text="${formatPrice.format(sale.discountedPrice)}원"
        sale_price.visibility = View.VISIBLE
    }
}