package kc.edu.onthi_chi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cau2Fragment extends Fragment {
    EditText editText_MET;
    EditText editText_KM;
    Button btnDoiDonVi;

    public Cau2Fragment() {

    }
    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
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
        // Inflate the layout for this fragment
        View viewCau1 = inflater.inflate(R.layout.fragment_cau2, container, false);
        //Tim dieu khien trong view
        editText_MET = viewCau1.findViewById(R.id.editSoMet);
        editText_KM = viewCau1.findViewById(R.id.editSoKiLoMet);
        btnDoiDonVi = viewCau1.findViewById(R.id.btnDoi);
        btnDoiDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soMet = editText_MET.getText().toString();
                String soKiLoMet = editText_KM.getText().toString();
                if (!soMet.isEmpty()) {//user có nhập diwx liệu m, cần đổi sang km
                    Toast.makeText(viewCau1.getContext(), "m -> km", Toast.LENGTH_SHORT).show();
                }
                else{//đổi từ km sang m
                    Toast.makeText(viewCau1.getContext(), "km -> m", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return viewCau1;
    }
}