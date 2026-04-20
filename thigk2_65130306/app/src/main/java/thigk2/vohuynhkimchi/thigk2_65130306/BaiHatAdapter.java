package thigk2.vohuynhkimchi.thigk2_65130306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BaiHatAdapter extends BaseAdapter {
    //
    private ArrayList<BaiHat> dsBaiHat;
    private LayoutInflater layoutInflater;
    private Context context;
    //ham tao


    public BaiHatAdapter(Context context, ArrayList<BaiHat> dsBaiHat) {
        this.context = context;
        this.dsBaiHat = dsBaiHat;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dsBaiHat.size();
    }

    @Override
    public Object getItem(int i) {
        return dsBaiHat.get(i);
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
            viewHienHanh = layoutInflater.inflate(R.layout.item_baihat,null);
        //lay du lieu
        BaiHat monAnHienTai = dsBaiHat.get(i);
        //Gan len cac dieu khien

        //Tim dieu khien
        TextView textView_Tenmon = (TextView) viewHienHanh.findViewById(R.id.idTenMonAn);
        ImageView imageView_HinhDaiDien = (ImageView) viewHienHanh.findViewById(R.id.idHinhDaiDien);

        //Set len
        textView_Tenmon.setText(monAnHienTai.getTenBaiHat());
        imageView_HinhDaiDien.setImageResource(monAnHienTai.getHinhAnh());

        return viewHienHanh;
    }
}