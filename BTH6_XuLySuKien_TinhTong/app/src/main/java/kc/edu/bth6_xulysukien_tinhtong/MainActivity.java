package kc.edu.bth6_xulysukien_tinhtong;

import android.os.Bundle;
import android.view.View;
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

    }
    // Đây là bộ lắng nghe và xử lý sự kiện Click lên nút Tính Tổng
    public void XuLyCong(View view) {
        //Tìm , tham chiếu đến điều khiển trên tệp XML
        EditText edtA = (EditText) findViewById(R.id.edtA);
        EditText edtB = (EditText) findViewById(R.id.edtB);
        EditText edtKQ = (EditText) findViewById(R.id.edtKQ);
        //Lấy dữ liệu về
        String strA = edtA.getText().toString();
        String strB = edtB.getText().toString();
        //Chuyển đổi dữ liệu về dạng số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);
        //Tinh tổng
        int kq = so_A + so_B;
        String strKQ = String.valueOf(kq); //chuyển sang dạng chuỗi
        //Hiển thị kết quả
        edtKQ.setText(strKQ);

    }
}