package com.example.navigationdrawer.NaviDrawerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ListView lvView = view.findViewById(R.id.lvMenu);
        List<Map<String,String>> menuList = new ArrayList<>();

        // Create and add the first menu item
        Map<String, String> item1 = new HashMap<>();
        item1.put("name", "ラーメン");
        item1.put("price", "2.000");
        menuList.add(item1);
        menuList.add(item1);
        menuList.add(item1);

        String[] from = new String[] {"name", "price"};
        int[] to = new int[] {R.id.row_title, R.id.row_subTitle};

        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                menuList,
                R.layout.list_menu,
                from,
                to
        );
        lvView.setAdapter(adapter);

        return view;
    }
}
