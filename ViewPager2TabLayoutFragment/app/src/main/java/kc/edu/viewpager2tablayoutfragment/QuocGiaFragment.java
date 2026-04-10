package kc.edu.viewpager2tablayoutfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class QuocGiaFragment extends Fragment {
    private static final String ARG_QUOC_GIA = "quoc_gia";
    QuocGia quocGia;
    
    public QuocGiaFragment() {
        // Default constructor required for Fragment
    }
    
    public static QuocGiaFragment newInstance(QuocGia quocGia) {
        QuocGiaFragment fragment = new QuocGiaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUOC_GIA + "_name", quocGia.getCountryName());
        args.putString(ARG_QUOC_GIA + "_flag", quocGia.getCountryFlag());
        args.putInt(ARG_QUOC_GIA + "_population", quocGia.getPopulation());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String name = getArguments().getString(ARG_QUOC_GIA + "_name");
            String flag = getArguments().getString(ARG_QUOC_GIA + "_flag");
            int population = getArguments().getInt(ARG_QUOC_GIA + "_population");
            quocGia = new QuocGia(name, flag, population);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quoc_gia, container, false);
        TextView textViewTenQG = view.findViewById(R.id.textViewCountryName);
        TextView textViewDanSo = view.findViewById(R.id.textViewPopular);
        ImageView imageViewFlag = view.findViewById(R.id.imageViewFlag);
        textViewTenQG.setText(quocGia.getCountryName());
        textViewDanSo.setText("Population: " + String.valueOf(quocGia.getPopulation()));
        int resourceId = view.getResources().getIdentifier(quocGia.getCountryFlag(), "drawable", view.getContext().getPackageName());
        imageViewFlag.setImageResource(resourceId);
        return view;
    }
}