package org.techtown.catsby.community;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.techtown.catsby.R;

import java.util.List;


public class FragmentCommunity extends Fragment {

    public FragmentCommunity() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        String[] list = {"고양이가 많이 아파요..", "다들 고양이 얼마나 키우셨나요?", "(사진)"};

        ListView listView = (ListView) view.findViewById(R.id.list);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list
        );

        listView.setAdapter(listViewAdapter);

        // textView = (TextView)view.findViewById(R.id.textView);

        return view;
    }
}