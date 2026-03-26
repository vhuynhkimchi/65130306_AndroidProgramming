package kc.edu.docbaotonghop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ArrayBaiBaoAdapter extends RecyclerView.Adapter<ArrayBaiBaoAdapter.ItemBBViewHolder > {
    Context context;
    ArrayList<ItemBaiBao> dsBaiBao;

    public ArrayBaiBaoAdapter(Context context, ArrayList<ItemBaiBao> dsBaiBao) {
        this.context = context;
        this.dsBaiBao = dsBaiBao;
    }

    @NonNull
    @Override
    public ItemBBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater napLayout = LayoutInflater.from(context);
        View viewItemBB = napLayout.inflate(R.layout.itembaibao, parent, false);
        ItemBBViewHolder viewHolder = new ItemBBViewHolder(viewItemBB);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBBViewHolder holder, int position) {
        //Lấy phần tử ở vị trí position trong dsBaiBao
        ItemBaiBao baiBaoCuThe = dsBaiBao.get(position);
        holder.tvTieuDeBB.setText(baiBaoCuThe.getTieuDeBaiBao());
        holder.tvNgayDangBB.setText(baiBaoCuThe.getThoiDiemBanTin());
        
        // Load ảnh từ URL sử dụng Glide
        String imageUrl = baiBaoCuThe.getUrlAnhDaiDien();
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .into(holder.anhBB);
        }
    }

    @Override
    public int getItemCount() {
        return dsBaiBao.size();
    }

    static final class ItemBBViewHolder extends RecyclerView.ViewHolder {
        ImageView anhBB;
        TextView tvTieuDeBB;
        TextView tvNgayDangBB;
        public ItemBBViewHolder(@NonNull View itemView) {
            super(itemView);
            anhBB = itemView.findViewById(R.id.ivAnhDaiDien);
            tvTieuDeBB = itemView.findViewById(R.id.tvTieuDe);
            tvNgayDangBB = itemView.findViewById(R.id.tvNgayDang);
        }

    }
}
