package net.projectmovies.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.part_shop_item.view.*
import net.projectmovies.R

class ShopAdapter (val shopItemList: List<ShopData>, val clickListener: (ShopData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.part_shop_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(shopItemList[position], clickListener)

    }

    override fun getItemCount() = shopItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: ShopData, clickListener: (ShopData) -> Unit) {
            itemView.shop_part_item_name.text = part.itemName
            itemView.shop_part_id.text = part.id.toString() + " Forint"
            itemView.setOnClickListener { clickListener(part)}

        }

    }

}
