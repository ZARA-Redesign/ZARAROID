package snp.zararoid.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import snp.zararoid.R
import snp.zararoid.databinding.ActivityMainBinding
import snp.zararoid.ui.menu.MenuActivity

class MainActivity : AppCompatActivity() {

    private var viewPagerAdapter: MainViewPagerAdapter? = null

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


}