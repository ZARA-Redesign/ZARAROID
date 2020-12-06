package snp.zararoid.ui.main.product.rcv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import snp.zararoid.R
import snp.zararoid.network.response.ProductData

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {
    var data = mutableListOf<ProductData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return when (viewType) {
            BIG_VIEW_TYPE -> makeProductViewHolder(R.layout.product_item_big, parent)
            SMALL_VIEW_TYPE -> makeProductViewHolder(R.layout.product_item_small,parent)
            else -> throw IllegalArgumentException("정상적이지 않은 뷰 타입입니다.")
        }
    }

    private fun makeProductViewHolder(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup
    ): ProductViewHolder = LayoutInflater.from(parent.context)
        .inflate(layoutRes, parent, false)
        .let { ProductViewHolder(it) }


    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 2) BIG_VIEW_TYPE else SMALL_VIEW_TYPE
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    companion object {
        private const val BIG_VIEW_TYPE = 1
        private const val SMALL_VIEW_TYPE = 0
    }

}