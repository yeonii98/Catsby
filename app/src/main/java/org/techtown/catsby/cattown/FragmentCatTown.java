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
import org.techtown.catsby.cattown.adapter.FragmentCatTownAdapter;
import org.techtown.catsby.cattown.model.Cat;

import java.util.ArrayList;

public class FragmentCatTown extends Fragment {
    RecyclerView recyclerView;
    FragmentCatTownAdapter adapter;
    ArrayList<Cat> catList;

    private int catpicture;
    private String name;
    private int helppeople;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cattown, container, false);
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyceler_view);
        catList = new ArrayList<>();

        adapter = new FragmentCatTownAdapter(catList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        catpicture = R.drawable.pic_001;
        name = "Happy";
        helppeople = 2;

        addItem(catpicture, name + "  1", helppeople);
        addItem(catpicture, name+ "  2", helppeople);
        addItem(catpicture, name + "  3", helppeople);
        addItem(catpicture, name + "  4", helppeople);
        addItem(catpicture, name + "  5", helppeople);
        addItem(catpicture, name + "  6", helppeople);
        addItem(catpicture, name + "  7", helppeople);
        addItem(catpicture, name + "  8", helppeople);
        addItem(catpicture, name + "  9", helppeople);
        addItem(catpicture, name + "  6", helppeople);
        addItem(catpicture, name + "  7", helppeople);
        addItem(catpicture, name + "  8", helppeople);
        addItem(catpicture, name + "  9", helppeople);
        addItem(catpicture, name + "  6", helppeople);
        addItem(catpicture, name + "  7", helppeople);
        addItem(catpicture, name + "  8", helppeople);
        addItem(catpicture, name + "  9", helppeople);

        adapter.notifyDataSetChanged();
        return view;
    }

    private void addItem(int picture, String catName, int helper) {
        Cat cat = new Cat();
        cat.setCatPicture(picture);
        cat.setName(catName);
        cat.setHelpPeople(helper);
        catList.add(cat);
    }
}
