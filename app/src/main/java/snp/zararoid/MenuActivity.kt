package snp.zararoid

import android.content.Intent
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.FontRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.fragment_product.*


class MenuActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: MenuViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        viewPagerAdapter = MenuViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.fragments = listOf(
            WomanFragment()
        )
        menu_viewpager.adapter = viewPagerAdapter

        tab_menu.setupWithViewPager(menu_viewpager)
        tab_menu.getTabAt(0)?.text="WOMAN"
        tab_menu.getTabAt(1)?.text="MAN"
        tab_menu.getTabAt(2)?.text="KIDS"

        BacktoMain()
    }


    fun BacktoMain() {
        back_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}