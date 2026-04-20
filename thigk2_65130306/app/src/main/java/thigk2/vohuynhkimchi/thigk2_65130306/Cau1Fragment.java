package thigk2.vohuynhkimchi.thigk2_65130306;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cau1Fragment extends Fragment {
    EditText editText_VND;
    EditText editText_DOLA;
    Button btnDoiDonVi;

    // Tỉ giá 1 USD = 25,000 VND
    private static final double TI_GIA = 25000.0;

    public Cau1Fragment() {

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
        View viewCau1 = inflater.inflate(R.layout.fragment_cau1, container, false);
        //Tim dieu khien trong view
        editText_VND = viewCau1.findViewById(R.id.editSoTienVND);
        editText_DOLA = viewCau1.findViewById(R.id.editSoTienDola);
        btnDoiDonVi = viewCau1.findViewById(R.id.btnDoi);
        btnDoiDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soTienVND = editText_VND.getText().toString();
                String soTienDola = editText_DOLA.getText().toString();
                if (!soTienVND.isEmpty()) {
                    // Đổi VND sang Dola
                    double vnd = Double.parseDouble(soTienVND);
                    double dola = vnd / TI_GIA;
                    editText_DOLA.setText(String.format("%.2f", dola));
                    Toast.makeText(viewCau1.getContext(), "VND -> Dola", Toast.LENGTH_SHORT).show();
                } else if (!soTienDola.isEmpty()) {
                    // Đổi Dola sang VND
                    double dola = Double.parseDouble(soTienDola);
                    double vnd = dola * TI_GIA;
                    editText_VND.setText(String.format("%.0f", vnd));
                    Toast.makeText(viewCau1.getContext(), "Dola -> VND", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(viewCau1.getContext(), "Vui lòng nhập số tiền!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return viewCau1;
    }
}