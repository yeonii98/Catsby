package org.techtown.catsby.cattown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.catsby.R;

import java.util.ArrayList;

public class FragmentCattownAdapter extends RecyclerView.Adapter<FragmentCatTownHolder> {
    private ArrayList<String> arrayList;
    public FragmentCattownAdapter() {
        arrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public FragmentCatTownHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragmentcattown_list, parent, false);
        FragmentCatTownHolder viewholder = new FragmentCatTownHolder(context, view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull FragmentCatTownHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setArrayData(String strData) {
        arrayList.add(strData);
    }
}

