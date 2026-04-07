package kc.edu.ontapbott;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        
        // Load WelcomeFragment on startup
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frgSpace, new WelcomeFragment())
                    .commit();
            bottomNav.setSelectedItemId(R.id.nav_welcome);
        }
        
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_welcome) {
                    selectedFragment = new WelcomeFragment();
                } else if (itemId == R.id.nav_cau1) {
                    selectedFragment = new Cau1Fragment();
                } else if (itemId == R.id.nav_cau2) {
                    selectedFragment = new Cau2Fragment();
                } else if (itemId == R.id.nav_cau3) {
                    selectedFragment = new Cau3Fragment();
                } else if (itemId == R.id.nav_cau4) {
                    selectedFragment = new Cau4Fragment();
                }
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frgSpace, selectedFragment).commit();

                }
                return true;
            }
        });
    }
}