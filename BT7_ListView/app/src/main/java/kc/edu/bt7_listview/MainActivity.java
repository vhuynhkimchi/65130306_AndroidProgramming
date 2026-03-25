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
    ArrayList<String> dsTenTinhThanhVN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên ListView
        //B1: cần có dữ liệu
        //khai bao
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
        // gắn bộ lắng nghe vào
        lvTenTinh.setOnItemClickListener(BoLangNghevaXL);
    }
    //Tạo bộ lắng nghe và xử lý sự kiện OnItemClick, đặt vào một biến
    //vd: BoLangNghevaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
            //Code xu ly o day
            // i la vi tri phan tu vua duoc click
            String strTenTinhChon = dsTenTinhThanhVN.get(i);
            // Hiển thị thông báo
            Toast.makeText(MainActivity.this, "Bạn chọn: " + strTenTinhChon, Toast.LENGTH_SHORT).show();

        }
        };

}
