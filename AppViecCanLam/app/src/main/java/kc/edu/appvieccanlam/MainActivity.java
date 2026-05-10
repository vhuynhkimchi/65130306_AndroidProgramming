package kc.edu.appvieccanlam;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASKS> lstVCL;
    TaskRVadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Tạo kết nối đến CSDL
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("TASKS");
        databaseReference.addValueEventListener(ngheFB);

        //Tim dieu khien
        RecyclerView recyclerView = findViewById(R.id.rvVCL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new TaskRVadapter(lstVCL);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    // Lắng nghe và xử lý
    ValueEventListener ngheFB = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            lstVCL.clear();
            // Lấý dữ liệu từ biến snapshot  dựa vao một biến danh sách để xử lý
            for(DataSnapshot ob: snapshot.getChildren()){
                TASKS tasks = ob.getValue(TASKS.class);
                lstVCL.add(tasks);
                Log.w("VCL app", "Tên việc cần làm: " + tasks.getName());
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
}