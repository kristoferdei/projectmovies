package net.projectmovies.shop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_shop.*
import net.projectmovies.R

class ShopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        shop_parts.layoutManager = LinearLayoutManager(this)

        shop_parts.setHasFixedSize(true)
        val Data = createData()

        shop_parts.adapter =
            ShopAdapter(
                Data,
                { partItem: ShopData -> partItemClicked(partItem) })

    }

        private fun partItemClicked(shopItem: ShopData) {
            Toast.makeText(this, "Kiválasztva: ${shopItem.itemName}", Toast.LENGTH_LONG).show()
            val showDetailActivityIntent = Intent(this, ShopDetailActivity::class.java)
            showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, shopItem.id.toString())
            startActivity(showDetailActivityIntent)

        }

    private fun createData() : List<ShopData> {
        val shopList = ArrayList<ShopData>()
        shopList.add(
            ShopData(
                930,
                "Popcorn - közepes ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1070,
                "Popcorn - nagy ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1510,
                "Popcorn - páros ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1170,
                "Nachos - közepes ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1320,
                "Nachos - nagy ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1770,
                "Nachos - páros ajánlat"
            )
        )
        shopList.add(
            ShopData(
                950,
                "Crispers - közepes ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1230,
                "Crispers - nagy ajánlat"
            )
        )
        shopList.add(
            ShopData(
                1680,
                "Crispers - páros ajánlat"
            )
        )
        return shopList

    }

}
