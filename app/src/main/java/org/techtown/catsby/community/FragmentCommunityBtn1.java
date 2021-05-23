package org.techtown.catsby.community;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.techtown.catsby.R;


public class FragmentCommunityBtn1 extends Fragment {


    private Button toastBtn;

    public FragmentCommunityBtn1() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_community_btn1, container);

        init(view);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_community_btn1, container, false);
    }
    private void init(View view) {
        toastBtn = view.findViewById(R.id.toastBtn);
    }
}