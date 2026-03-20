package kc.edu.baith5_xulysukien1;

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
   EditText editTextSo1, editTextSo2;
   EditText editTextKetQua;
   Button nutCong, nutTru, nutNhan, nutChia;
    void TimDieuKien(){
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        EditText editTextKetQua = (EditText) findViewById(R.id.edtKetQua);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKien();
        //Gắn bộ lắng nghe sự kiện và code xử lý cho từng nút
        View.OnClickListener bolangngheCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xu ly cong o day
                //b1.Lấy dữ liệu 2 số
                //b1.1. Tìm EditText số 1 vaf 2
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
                //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String ketQua = String.valueOf(tong);
                //b3.3. Gắn kết quả lên dk
                editTextKetQua.setText(ketQua);
            }
        };
        nutCong.setOnClickListener(bolangngheCong);
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b1.Lấy dữ liệu 2 số
                //b1.1. Tìm EditText số 1 vaf 2
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
                //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String ketQua = String.valueOf(hieu);
                //b3.3. Gắn kết quả lên dk
                editTextKetQua.setText(ketQua);
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b1.Lấy dữ liệu 2 số
                //b1.1. Tìm EditText số 1 vaf 2
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
                //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String ketQua = String.valueOf(nhan);
                //b3.3. Gắn kết quả lên dk
                editTextKetQua.setText(ketQua);
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b1.Lấy dữ liệu 2 số
                //b1.1. Tìm EditText số 1 vaf 2
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
                //b3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String ketQua = String.valueOf(chia);
                //b3.3. Gắn kết quả lên dk
                editTextKetQua.setText(ketQua);
            }
        });
    }

}