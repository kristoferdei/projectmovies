package net.projectmovies.shop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shop_detail.*
import net.projectmovies.R

class ShopDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)

        var intent = getIntent()

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            var shopId = intent.getStringExtra(Intent.EXTRA_TEXT)
            shop_item_id.text = shopId.toString() + " Forint"

        }

    }

}
