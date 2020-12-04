package snp.zararoid.ui.main.rcv

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import snp.zararoid.R
import java.text.DecimalFormat

class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    init {

    }

    private val event: TextView = itemView.findViewById(R.id.txt_event)
    private val title: TextView = itemView.findViewById(R.id.txt_title)
    private val org_price: TextView = itemView.findViewById(R.id.txt_original_price)
    private val sale_price: TextView = itemView.findViewById(R.id.txt_sale_price)
    private val imageNum: ImageView = itemView.findViewById(R.id.img_product)
    val formatPrice = DecimalFormat("#,###,###") //천단위마다 , 추가

    fun onBind(data: ProductData){
        if(data.event==0){
            event.text = "NEW"
        }else if(data.event==1){
            event.text = data.sale_percent.toString() + "% OFF"
            org_price.setPaintFlags(org_price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG) //원래 가격에 취소선 적용
            sale_price.text=formatPrice.format((data.org_price * (100-data.sale_percent)/100)).toString()+"원"
            sale_price.visibility = View.VISIBLE
        }else{
            event.text = "HOT"
        }
        title.text=data.title
        org_price.text=formatPrice.format(data.org_price).toString() + "원"
        imageNum.setImageResource(data.imageNum)
    }
}