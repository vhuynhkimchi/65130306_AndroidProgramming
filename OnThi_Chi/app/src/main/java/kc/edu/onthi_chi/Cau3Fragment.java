package kc.edu.onthi_chi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau3Fragment extends Fragment {

    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandscape;

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
        recyclerViewDatas = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("ho_hoan_kiem", "Hoàn Kiếm","Địa điểm nổi tiếng");
        LandScape landScape2 = new LandScape("vinh_ha_long", "Vịnh Hạ Long", "Top 10 địa điểm đẹp nhất Châu Á");
        LandScape landScape3 = new LandScape("cau_vang", "Cầu Vàng","Địa điểm thu hút nhất khi đến Đà Nẵng.");
        LandScape landScape4 = new LandScape("chua_mot_cot", "Chùa Một Cột","Địa điểm đẹp nhất Hà Nội");
        recyclerViewDatas.add(landScape1);
        recyclerViewDatas.add(landScape2);
        recyclerViewDatas.add(landScape3);
        recyclerViewDatas.add(landScape4);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau3 = inflater.inflate(R.layout.fragment_cau3, container, false);
        //4
        recyclerViewLandscape = viewCau3.findViewById(R.id.ryCau3);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(viewCau3.getContext());
        recyclerViewLandscape.setLayoutManager(layoutLinear);
        //6
        landScapeAdapter = new LandScapeAdapter(viewCau3.getContext(), recyclerViewDatas);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdapter);
        // Inflate the layout for this fragment
        return viewCau3;
    }
}