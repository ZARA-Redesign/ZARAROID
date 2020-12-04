package snp.zararoid.ui.main.rcv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import snp.zararoid.R

class ProductAdapter(private val context: Context): RecyclerView.Adapter<ProductViewHolder>() {
    var data = mutableListOf<ProductData>()
    var viewType: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = when(viewType){
            1 -> {LayoutInflater.from(context).inflate(R.layout.product_item_big, parent, false)}
            else -> {LayoutInflater.from(context).inflate(R.layout.product_item_small, parent, false)}
        }
        return ProductViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if(position % 3 == 2){
            viewType = 1
        }else{
            viewType = 0
        }
        return viewType
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

}