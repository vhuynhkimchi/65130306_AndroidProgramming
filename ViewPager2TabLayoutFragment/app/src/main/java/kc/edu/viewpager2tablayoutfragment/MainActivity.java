package kc.edu.viewpager2tablayoutfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List< QuocGia> dsQuocGia;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    QuocGiaPagerAdapter quocGiaPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsQuocGia = new ArrayList<QuocGia>();
        QuocGia qg1 = new QuocGia("Vietnam", "vietnam", 95500000);
        QuocGia qg2 = new QuocGia("United States", "us", 1400000000);
        QuocGia qg3 = new QuocGia("Russia", "russia", 12300000);
        dsQuocGia.add(qg1);
        dsQuocGia.add(qg2);
        dsQuocGia.add(qg3);
        viewPager2 = findViewById(R.id.viewPageQG);
        quocGiaPagerAdapter = new QuocGiaPagerAdapter(this, dsQuocGia);

        viewPager2.setAdapter(quocGiaPagerAdapter);

        tabLayout = findViewById(R.id.tabQuocGia);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText("QG" + (position + 1))) ;
        tabLayoutMediator.attach();

    }
}