package thigk2.vohuynhkimchi.thigk2_65130306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DanhNhanAdapter extends RecyclerView.Adapter<DanhNhanAdapter.ItemDanhNhanHolder> {
    Context context;
    ArrayList<DanhNhan> lstData;

    public DanhNhanAdapter(Context context, ArrayList<DanhNhan> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemDanhNhanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View viewItem = cai_bom.inflate(R.layout.item_danhnhan, parent, false);
        ItemDanhNhanHolder viewholderCreated = new ItemDanhNhanHolder(viewItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDanhNhanHolder holder, int position) {
        //Lay doi tuong hien thi
        DanhNhan danhNhanHienThi = lstData.get(position);
        //Trich thong tin
        String tenDanhNhan = danhNhanHienThi.getName();
        String queQuan = danhNhanHienThi.getQueQuan();
        String tenAnh = danhNhanHienThi.getDanhnhanImageFileName();

        //Dat vao cac truong thong tin cua Holder
        holder.tvTieuDe.setText(tenDanhNhan);
        holder.tvMoTa.setText(queQuan);
        //dat anh
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenAnh, "drawable", packageName);
        holder.ivAnhDaiDien.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemDanhNhanHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTieuDe;
        TextView tvMoTa;
        ImageView ivAnhDaiDien;

        public ItemDanhNhanHolder(@NonNull View itemView) {
            super(itemView);
            tvTieuDe = itemView.findViewById(R.id.tvTieuDe);
            tvMoTa = itemView.findViewById(R.id.tvMoTa);
            ivAnhDaiDien = itemView.findViewById(R.id.ivAnhDaiDien);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriDuocClick = getAbsoluteAdapterPosition();
            DanhNhan phanTuDuocClick = lstData.get(viTriDuocClick);
            //lay thong tin
            String ten = phanTuDuocClick.getName();
            String tenFile = phanTuDuocClick.getDanhnhanImageFileName();
            //
            String chuoiThongBao = "Ban vua click vao : " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }
    }
}
