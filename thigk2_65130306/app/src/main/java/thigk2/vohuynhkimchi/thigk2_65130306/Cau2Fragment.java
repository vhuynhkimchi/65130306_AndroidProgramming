package thigk2.vohuynhkimchi.thigk2_65130306;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Cau2Fragment extends Fragment {

    BaiHatAdapter baiHatAdapter;
    ArrayList<BaiHat> recyclerViewDatas;
    ListView listViewBaiHat;

    public Cau2Fragment() {
        // Required empty public constructor
    }

    public static Cau2Fragment newInstance(String param1, String param2) {
        Cau2Fragment fragment = new Cau2Fragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Chuẩn bị dữ liệu
        recyclerViewDatas = new ArrayList<BaiHat>();
        BaiHat baiHat1 = new BaiHat("Võ Huỳnh Kim Chi-65130306", R.drawable.cmvn);
        BaiHat baiHat2 = new BaiHat("Tiến quân ca", R.drawable.cmvn);
        BaiHat baiHat3 = new BaiHat("Như có Bác trong ngày đại thắng", R.drawable.cmvn);
        BaiHat baiHat4 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);
        BaiHat baiHat5 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);
        BaiHat baiHat6 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);
        BaiHat baiHat7 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);
        BaiHat baiHat8 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);
        BaiHat baiHat9 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);
        BaiHat baiHat10 = new BaiHat("Mùa xuân trên Thành phố Hồ Chí Minh", R.drawable.cmvn);

        recyclerViewDatas.add(baiHat1);
        recyclerViewDatas.add(baiHat2);
        recyclerViewDatas.add(baiHat3);
        recyclerViewDatas.add(baiHat4);
        recyclerViewDatas.add(baiHat5);
        recyclerViewDatas.add(baiHat6);
        recyclerViewDatas.add(baiHat7);
        recyclerViewDatas.add(baiHat8);
        recyclerViewDatas.add(baiHat9);
        recyclerViewDatas.add(baiHat10);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau2 = inflater.inflate(R.layout.fragment_cau2, container, false);
        // Tìm ListView trong layout
        listViewBaiHat = viewCau2.findViewById(R.id.lvDSBaiHat);
        // Tạo adapter
        baiHatAdapter = new BaiHatAdapter(viewCau2.getContext(), recyclerViewDatas);
        // Gán adapter cho ListView
        listViewBaiHat.setAdapter(baiHatAdapter);
        // Inflate the layout for this fragment
        return viewCau2;
    }
}