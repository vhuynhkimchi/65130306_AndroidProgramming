package kc.edu.docbaotonghop;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TieuDeBaiBaoActivity extends AppCompatActivity {
    RecyclerView recyclerViewBB;
    ArrayBaiBaoAdapter arrayBBAdapter;
    ArrayList<ItemBaiBao> dsBaiBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tieu_de_bai_bao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewBB = findViewById(R.id.lvDSBaiBao);
        dsBaiBao = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewBB.setLayoutManager(layoutManager);
        arrayBBAdapter = new ArrayBaiBaoAdapter(this, dsBaiBao);
        recyclerViewBB.setAdapter(arrayBBAdapter);

        // Gọi Parser RSS
        String vnExpressSport = "https://vnexpress.net/rss/the-thao.rss";
        new RSSParser().getNews(vnExpressSport, new RSSParser.RSSCallback() {
            @Override
            public void onSuccess(ArrayList<NewsObject> listNews) {
                // Phải chạy trên UI Thread để cập nhật giao diện
                runOnUiThread(() -> {
                    dsBaiBao.clear();
                    for (int i = 0; i < listNews.size(); i++) {
                        NewsObject newsObject = listNews.get(i);
                        dsBaiBao.add(new ItemBaiBao(
                            newsObject.getTitle(),
                            newsObject.getImageUrl(),
                            newsObject.getPubDate()
                        ));
                    }
                    arrayBBAdapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }

    ArrayList<ItemBaiBao> getData() {
        ArrayList<ItemBaiBao> ds = new ArrayList<>();
        ds.add(new ItemBaiBao("Bai 1", "url1", "ngay1"));
        ds.add(new ItemBaiBao("Bai 2", "url2", "ngay2"));
        ds.add(new ItemBaiBao("Bai 3", "url3", "ngay3"));
        return ds;
    }
}