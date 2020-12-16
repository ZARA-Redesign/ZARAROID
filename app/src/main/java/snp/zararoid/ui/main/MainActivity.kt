package snp.zararoid.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import snp.zararoid.R
import snp.zararoid.databinding.ActivityMainBinding
import snp.zararoid.ui.main.product.ProductListFragment
import snp.zararoid.ui.menu.MenuActivity

class MainActivity : AppCompatActivity() {

    private var viewPagerAdapter: MainViewPagerAdapter? = null
    private var fragmentProductList: ProductListFragment = ProductListFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivity = this@MainActivity
        initViewPager(binding)
    }

    private fun initViewPager(binding: ActivityMainBinding) {
        viewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        binding.mainViewpager.adapter = viewPagerAdapter
    }

    fun onClickBottomMenu() {
        val intentToChangeMenu = Intent(this@MainActivity, MenuActivity::class.java)
        startActivity(intentToChangeMenu)
    }

    fun passValue(category: String){
        fragmentProductList.receiveCategoryValue(category)
        Log.d("pass", "Main "+ category)
    }
}