package org.techtown.catsby.cattown;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.catsby.R;

public class FragmentCatTown extends Fragment {

    RecyclerView recyclerView;
    FragmentCattownAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cattown, container, false);
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyceler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        adapter = new FragmentCattownAdapter();

        for (int i = 0; i < 100; i++) {
            String str = i + " 고양이";
            adapter.setArrayData(str);
        }
        recyclerView.setAdapter(adapter);
        return view;
    }
}
