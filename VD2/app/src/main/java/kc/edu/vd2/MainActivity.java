package kc.edu.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        // Thiết lập click listeners cho các buttons
        Button btnCong = findViewById(R.id.btnCong);
        Button btnTru = findViewById(R.id.btnTru);
        Button btnNhan = findViewById(R.id.btnNhan);
        Button btnChia = findViewById(R.id.btnChia);
        
        btnCong.setOnClickListener(v -> XuLyCong(v));
        btnTru.setOnClickListener(v -> XuLyTru(v));
        btnNhan.setOnClickListener(v -> XuLyNhan(v));
        btnChia.setOnClickListener(v -> XuLyChia(v));
    }

    //Xử lý cộng
    void XuLyCong(View v){
        //b1.Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 vaf 2
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        //b1.2. Lấy dữ liệu từ 2 EditText
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);
        //b2. Tính tổng
        float tong = soA + soB;
        //b3. Hiển thị kết quả
        //b3.1
        EditText editTextKetQua = (EditText) findViewById(R.id.edtKetQua);
        //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String ketQua = String.valueOf(tong);
        //b3.3. Gắn kết quả lên dk
        editTextKetQua.setText(ketQua);
    }
    void XuLyTru(View v){
        //b1.Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 vaf 2
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        //b1.2. Lấy dữ liệu từ 2 EditText
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);
        //b2. Tính tổng
        float hieu = soA - soB;
        //b3. Hiển thị kết quả
        //b3.1
        EditText editTextKetQua = (EditText) findViewById(R.id.edtKetQua);
        //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String ketQua = String.valueOf(hieu);
        //b3.3. Gắn kết quả lên dk
        editTextKetQua.setText(ketQua);
    }
    void XuLyNhan(View v){
        //b1.Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 vaf 2
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        //b1.2. Lấy dữ liệu từ 2 EditText
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);
        //b2. Tính tổng
        float nhan = soA * soB;
        //b3. Hiển thị kết quả
        //b3.1
        EditText editTextKetQua = (EditText) findViewById(R.id.edtKetQua);
        //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String ketQua = String.valueOf(nhan);
        //b3.3. Gắn kết quả lên dk
        editTextKetQua.setText(ketQua);
    }
    void XuLyChia(View v){
        //b1.Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 vaf 2
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        //b1.2. Lấy dữ liệu từ 2 EditText
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(so1);
        float soB = Float.parseFloat(so2);
        //b2. Tính tổng
        float chia = soA / soB;
        //b3. Hiển thị kết quả
        //b3.1
        EditText editTextKetQua = (EditText) findViewById(R.id.edtKetQua);
        //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String ketQua = String.valueOf(chia);
        //b3.3. Gắn kết quả lên dk
        editTextKetQua.setText(ketQua);
    }
}