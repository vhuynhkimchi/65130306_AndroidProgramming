package kc.edu.viewpager2tablayoutfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.UnknownNullability;

import java.util.List;

public class QuocGiaPagerAdapter extends FragmentStateAdapter {

    List<QuocGia> quocGiaList;
    public QuocGiaPagerAdapter(@NonNull @UnknownNullability MainActivity fragment, List<QuocGia> _dataSource) {
        super(fragment);
        quocGiaList = _dataSource;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        QuocGia quocGiaX = quocGiaList.get(position);
        return QuocGiaFragment.newInstance(quocGiaX);
    }

    @Override
    public int getItemCount() {

        return quocGiaList.size();
    }
}
