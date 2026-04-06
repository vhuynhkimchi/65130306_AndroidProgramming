package kc.edu.ontapbott;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.core.database.sqlite.SQLiteDatabaseKt;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Cau4Fragment extends Fragment {



    public Cau4Fragment() {
        // Required empty public constructor
    }

    public static Cau4Fragment newInstance(String param1, String param2) {
        Cau4Fragment fragment = new Cau4Fragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        //Buoc 0. Tạo file cơ sở dữ liệu
//        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", //ten fule
//                MODE_PRIVATE, //gioi han truy cap
//                null);// con tro ban ghi);
//
//        //B1. Tao Bang
//        //cau lenh tao bang
//        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS Books;";
//        String sqlTaoBang = "CREATE TABLE Books (BookID INTEGER PRIMARY KEY, " +
//                            "BookName TEXT," +
//                            "Page integer, " +
//                            "Price Float," +
//                            "Description TEXT);";
//        //Thuc hien lenh SQL
//        db.execSQL(sqlXoaBangNeuDaCo);
//        db.execSQL(sqlTaoBang);
//        //Them mot so dong du lieu vao bang
//        String sqlThem1 = "INSERT INTO Books VALUES (1, 'Java', 100, 9.99, 'sach ve java'); ";
//        String sqlThem2 = "INSERT INTO Books VALUES (2, 'Android', 320, 19.99, 'android co ban'); ";
//        String sqlThem3 = "INSERT INTO Books VALUES (3, 'English - Vietnamese', 450, 14.99, 'Tu dien anh-viet'); ";
//        String sqlThem4 = "INSERT INTO Books VALUES (4, 'C+', 240, 10.99, 'sach ve C+'); ";
//        String sqlThem5 = "INSERT INTO Books VALUES (5, 'Phat Trien Ban Than', 280, 15.99, 'sach ve phat trien ban than'); ";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//
//        //Để quan sát trực quan file .db => Dùng ứng dụng DB BRowser for SQLite
//        //Để miwr được file ta save file từ điện thoại ra đĩa cứng
//
//        //Ta đóng lại để check
//        db.close();

        //b1. Mo CSDL
        if (getActivity() == null) return null;
        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);
        //B2. Thuc Thi cau lenh Select
        String sqlSelect = "SELECT * FROM Books;";
        Cursor cursor = db.rawQuery(sqlSelect, null);
        cursor.moveToFirst(); //đưa con troe bản ghi về hàng đầu tiên
        //B3. Đổ vào biến nào đó để xử lý
        //3.1. Xây dựng model/class cho bảng Books, ví dụ: Book.java
        //3.2. Tạo beiens ArrayList<Book> dsSach;
        ArrayList<Book> dsSach = new ArrayList<>();
        //3.3. Duyệt qua từng bản ghi và thêm vào danh sách
        while (!cursor.isAfterLast()) {
            int idSach = cursor.getInt(0);
            String tenSach = cursor.getString(1);
            int soTrang = cursor.getInt(2);
            float gia = cursor.getFloat(3);
            String mota = cursor.getString(4);
            Book book = new Book(idSach, tenSach, soTrang, gia, mota);
            dsSach.add(book);
            cursor.moveToNext();
        }
        cursor.close();
        //B4.Hiểnj lên listView, Recyclerview,...
        ArrayList<String> dsTenSach = new ArrayList<>();
        for (int i = 0; i < dsSach.size(); i++) {
            dsTenSach.add(dsSach.get(i).getBookName());
        }
        //Hiển thị lên dk ListView
        View viewCau4 = inflater.inflate(R.layout.fragment_cau4, container, false);

        ListView listViewTenSach = viewCau4.findViewById(R.id.lvTenSach);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                dsTenSach
        );
        listViewTenSach.setAdapter(adapter);
        //Lắng Nghe và xl
        //listViewTenSach.setOnItemClickListener((parent, view, position, id) -> ));
        // Inflate the layout for this fragment
        return viewCau4;
    }
}