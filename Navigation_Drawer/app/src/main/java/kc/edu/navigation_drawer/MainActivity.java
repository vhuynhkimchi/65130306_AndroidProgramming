package kc.edu.navigation_drawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu; // Thêm import này
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Đã sửa lỗi dòng lệnh bị bỏ dở và sai ID
        Menu menu = navigationView.getMenu();
        // Nếu bạn muốn làm gì đó với item logout khi khởi tạo, hãy viết ở đây.
        // Nếu không cần thì có thể xóa 2 dòng dưới.
        MenuItem logoutItem = menu.findItem(R.id.nav_logout);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Sửa R.nav_home thành R.id.nav_home
        navigationView.setCheckedItem(R.id.nav_home);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Sửa lỗi dấu ; thành : và lỗi logic chuyển Activity
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Đang ở Home nên không cần làm gì hoặc load Fragment Home
        } else if (id == R.id.nav_bus) {
            Intent intent = new Intent(MainActivity.this, Bus.class);
            startActivity(intent); // Sửa từ startActivities thành startActivity
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    // Các hàm xử lý sự kiện onClick cho 6 ô
    public void onBicycleClick(View view) {
        Toast.makeText(this, "Bicycle selected", Toast.LENGTH_SHORT).show();
        // Xử lý chuyển Activity ở đây
    }

}