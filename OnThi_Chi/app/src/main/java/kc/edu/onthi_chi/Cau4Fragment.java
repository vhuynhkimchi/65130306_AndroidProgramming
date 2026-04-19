package kc.edu.onthi_chi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class Cau4Fragment extends Fragment {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    public Cau4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Nạp layout
        View view = inflater.inflate(R.layout.fragment_cau4, container, false);

        // Ánh xạ View
        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.nav_view);
        toolbar = view.findViewById(R.id.toolbar);
        CardView cardBicycle = view.findViewById(R.id.card_bicycle);

        // 1. Thiết lập Toolbar & Nút kéo Menu (Hamburger Icon)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // 2. Xử lý sự kiện khi click vào Menu trượt
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Chú ý: Ở đây bạn dùng R.id lấy từ main_menu.xml
                if (id == R.id.nav_home) {
                    Toast.makeText(getContext(), "Home clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_bus) {
                    Toast.makeText(getContext(), "Bus clicked", Toast.LENGTH_SHORT).show();
                    // Intent intent = new Intent(getActivity(), Bus.class);
                    // startActivity(intent);
                } else if (id == R.id.nav_logout) {
                    Toast.makeText(getContext(), "Logout clicked", Toast.LENGTH_SHORT).show();
                }

                // Đóng Drawer sau khi chọn
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // 3. Xử lý sự kiện click trên ô của Dashboard
        cardBicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Bicycle selected", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}