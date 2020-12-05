package snp.zararoid.ui.menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*
import snp.zararoid.R
import snp.zararoid.ui.main.MainActivity


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