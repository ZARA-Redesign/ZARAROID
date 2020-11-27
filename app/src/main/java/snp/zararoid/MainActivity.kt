package snp.zararoid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        main_viewpager.adapter = viewPagerAdapter
        main_viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            //뷰페이저의 페이지 중 하나가 선택된 경우
            override fun onPageSelected(position: Int) {
            }
        })

    }
}