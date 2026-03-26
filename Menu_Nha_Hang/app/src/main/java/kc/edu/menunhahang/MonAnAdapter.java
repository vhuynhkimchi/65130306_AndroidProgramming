package kc.edu.menunhahang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    //
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;
    //ham tao


    public MonAnAdapter(Context context, ArrayList<MonAn> dsMonAn) {
        this.context = context;
        this.dsMonAn = dsMonAn;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        //View cua Item hien hanh
        View viewHienHanh = view;
        // Kiem tra
        if (viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan,null);
        //lay du lieu
        MonAn monAnHienTai = dsMonAn.get(i);
        //Gan len cac dieu khien

        //Tim dieu khien
        TextView textView_Tenmon = (TextView) viewHienHanh.findViewById(R.id.idTenMonAn);
        TextView textView_DonGia = (TextView) viewHienHanh.findViewById(R.id.idDonGia);
        TextView textView_MoTa = (TextView) viewHienHanh.findViewById(R.id.idMoTa);
        ImageView imageView_HinhDaiDien = (ImageView) viewHienHanh.findViewById(R.id.idHinhDaiDien);

        //Set len
        textView_Tenmon.setText(monAnHienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView_HinhDaiDien.setImageResource(monAnHienTai.getHinhAnh());

        return viewHienHanh;
    }
}
