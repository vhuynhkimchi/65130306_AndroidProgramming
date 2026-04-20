package thigk2.vohuynhkimchi.thigk2_65130306;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau3Fragment extends Fragment {

    DanhNhanAdapter danhNhanAdapter;
    ArrayList<DanhNhan> recyclerViewDatas;
    RecyclerView recyclerViewDanhNhan;

    public Cau3Fragment() {
        // Required empty public constructor
    }

    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Chuẩn bị dữ liệu
        recyclerViewDatas = new ArrayList<DanhNhan>();
        DanhNhan danhnhan1 = new DanhNhan("hcm", "Hồ Chí Minh","Nghe An");
        DanhNhan danhnhan2 = new DanhNhan("hcm", "Hồ Chí Minh","Nghe An");
        DanhNhan danhnhan3 = new DanhNhan("hcm", "Hồ Chí Minh","Nghe An");
        DanhNhan danhnhan4 = new DanhNhan("hcm", "Hồ Chí Minh","Nghe An");
        DanhNhan danhnhan5 = new DanhNhan("hcm", "Hồ Chí Minh","Nghe An");
        recyclerViewDatas.add(danhnhan1);
        recyclerViewDatas.add(danhnhan2);
        recyclerViewDatas.add(danhnhan3);
        recyclerViewDatas.add(danhnhan4);
        recyclerViewDatas.add(danhnhan5);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau3 = inflater.inflate(R.layout.fragment_cau3, container, false);
        //4
        recyclerViewDanhNhan = viewCau3.findViewById(R.id.ryCau3);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(viewCau3.getContext());
        recyclerViewDanhNhan.setLayoutManager(layoutLinear);
        //6
        danhNhanAdapter = new DanhNhanAdapter(viewCau3.getContext(), recyclerViewDatas);
        //7
        recyclerViewDanhNhan.setAdapter(danhNhanAdapter);
        // Inflate the layout for this fragment
        return viewCau3;
    }
}