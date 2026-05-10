package kc.edu.appvieccanlam;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVadapter extends RecyclerView.Adapter {
    List<TASKS> dataSource;

    public TaskRVadapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }
    // Tạo ViewHolder

    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtViewTextVCL;
        TextView textViewThoiGian;

        public int position;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtViewTextVCL = itemView.findViewById(R.id.txtViewTextVCL);
            textViewThoiGian = itemView.findViewById(R.id.textViewThoiGian);
        }

        @Override
        public void onClick(View v) {
            //lay vi tri
            int vtClick = getAdapterPosition();
            // luc o nguon du lieu
            TASKS taskClicked = dataSource.get(vtClick);
            //xu ly, vi du ow day ta Toast
            Toast.makeText(v.getContext(),"Viec can lam: " + taskClicked.getName(), Toast.LENGTH_SHORT).show();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskViewHolder viewHolder = new TaskViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        TaskViewHolder viewHolder = (TaskViewHolder) holder;
        viewHolder.position = position;
        TASKS task = dataSource.get(position);
        ((TaskViewHolder) holder).txtViewTextVCL.setText(task.getName());
        ((TaskViewHolder) holder).textViewThoiGian.setText(task.getDate());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
