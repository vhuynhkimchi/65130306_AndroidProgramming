package kc.edu.menunhahang;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tìm ListView
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        //Chuânr bị dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));
        dsMonAn.add(new MonAn("Cơm Tấm Sườn", 25000, "Mô tả nội dung", R.drawable.img));

        MonAnAdapter adapter = new MonAnAdapter(this, dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        //Bắt xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //Lấy phần tử được chọn
                MonAn monAnChon = dsMonAn.get(i);

                Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}