package kc.edu.bt7_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên ListView
        //B1: cần có dữ liệu
        ArrayList<String> dsTenTinhThanhVN; //khai bao
        dsTenTinhThanhVN = new ArrayList<String>(); //Tao the hien cu the, xin moi
        //Them du lieu vao dsTenTinhThanhVN
        dsTenTinhThanhVN.add("An Giang");
        dsTenTinhThanhVN.add("Bà Rịa - Vũng Tàu");
        dsTenTinhThanhVN.add("Bạc Liêu");
        dsTenTinhThanhVN.add("Bắc Kạn");
        dsTenTinhThanhVN.add("Bắc Giang");
        dsTenTinhThanhVN.add("Bắc Ninh");
        dsTenTinhThanhVN.add("Bến Tre");
        dsTenTinhThanhVN.add("Bình Dương");
        dsTenTinhThanhVN.add("Bình Định");
        dsTenTinhThanhVN.add("Bình Phước");

        //B2. Tao adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTenTinhThanhVN);

        //B3.Gắn vào điều khiển hiển thị ListView
        //3.1 Tim
        ListView lvTenTinh = findViewById(R.id.lvDanhSachTinh);
        //3.2. Gan
        lvTenTinh.setAdapter(adapterTinhThanh);
        //3,3,Lang nghe va xu ly su kien user tuong tac
        // Tạo bộ lắng nghe và xử lý sự kiện OnItemClick, đặt vào một biến
        lvTenTinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Lấy tên tỉnh thành tại vị trí được click
                String tenTinhThanh = dsTenTinhThanhVN.get(position);
                // Hiển thị thông báo
                Toast.makeText(MainActivity.this,
                        "Bạn vừa chọn: " + tenTinhThanh,
                        Toast.LENGTH_SHORT).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (
                v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
