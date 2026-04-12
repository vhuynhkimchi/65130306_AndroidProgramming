package kc.edu.appbar_top;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    private MaterialToolbar topAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topAppBar = findViewById(R.id.topAppBar);
        // Navigation icon (hamburger/menu)
        topAppBar.setNavigationOnClickListener(v ->
                Toast.makeText(this, "Mở menu điều hướng", Toast.LENGTH_SHORT).show()
        );
        // Action menu item click
        // Action menu item click
        topAppBar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId(); // Lấy ID của item được click

            if (id == R.id.action_search) {
                Toast.makeText(this, "Tìm kiếm...", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.action_settings) {
                Toast.makeText(this, "Mở cài đặt", Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        });
    }
}