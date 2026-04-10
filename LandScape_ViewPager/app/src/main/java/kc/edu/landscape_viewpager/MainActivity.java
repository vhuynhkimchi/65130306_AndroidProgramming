package kc.edu.landscape_viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> ViewPagerDatas;
    ViewPager2 viewPager2Land;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        ViewPagerDatas = getDataForViewPager();
        //4
        viewPager2Land = findViewById(R.id.vp2Land);
        //6
        landScapeAdapter = new LandScapeAdapter(this, ViewPagerDatas);
        //7
        viewPager2Land.setAdapter(landScapeAdapter);
        viewPager2Land.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    ArrayList<LandScape> getDataForViewPager(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("ho_hoan_kiem", "Hồ Hoàn Kiếm");
        LandScape landScape2 = new LandScape("dong_phong_nha", "Động Phong Nha");
        LandScape landScape3 = new LandScape("cau_vang", "Cầu Vàng");
        LandScape landScape4 = new LandScape("vinh_ha_long", "Vịnh Hạ Long");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(landScape2);
        dsDuLieu.add(landScape3);
        dsDuLieu.add(landScape4);

        return dsDuLieu;
    }
}