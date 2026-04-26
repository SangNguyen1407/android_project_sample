package com.example.navigationdrawer.NaviDrawerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
        item1.put("name", "東京");
        item1.put("id", "270000");
        menuList.add(item1);

        Map<String, String> item2 = new HashMap<>();
        item2.put("name", "大阪");
        item2.put("id", "280000");
        menuList.add(item2);

        Map<String, String> item3 = new HashMap<>();
        item3.put("name", "神戸");
        item3.put("id", "290000");
        menuList.add(item3);

        String[] from = new String[] {"name", "id"};
        int[] to = new int[] {R.id.row_title, R.id.row_subTitle};

        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                menuList,
                R.layout.list_menu,
                from,
                to
        );
        lvView.setAdapter(adapter);
        lvView.setOnItemClickListener(new ListItemClickListener());

        return view;
    }
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//            ListViewでタップされた行の都市名と都市IDを取得
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            String cityName = item.get("name");
            String cityId = item.get("id");

            TextView tvCityName = view.findViewById(R.id.tvCityName);
            tvCityName.setText("       天気：");
        }
    }
}
