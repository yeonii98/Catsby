package org.techtown.catsby.community;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.techtown.catsby.community.FragmentCommunityNotice;
import org.techtown.catsby.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FragmentCommunity extends Fragment {
    private ListView noticeListView;
    private FragmentCommunityNoticeAdapter adapter;
    private List<FragmentCommunityNotice> noticeList;
    private Object FragmentCommunityNotice;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        super.onCreate(savedInstanceState);

        noticeListView = (ListView) view.findViewById(R.id.noticeListView);
        noticeList = new ArrayList<FragmentCommunityNotice>();
        noticeList.add(new FragmentCommunityNotice("고양이가 아픈데 병원 추천 부탁드려요ㅠㅠ", "익명", "2021-04-05"));
        noticeList.add(new FragmentCommunityNotice("냥이 츄르 같이 사실 분 계신가요~?", "연지니", "2021-04-03"));
        noticeList.add(new FragmentCommunityNotice("(사진)", "냥집사", "2021-04-02"));
        adapter = new FragmentCommunityNoticeAdapter(getActivity().getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        final Button courseButton = (Button) view.findViewById(R.id.courseButton);
        final Button statisticsButton = (Button) view.findViewById(R.id.statisticsButton);
        final Button scheduleButton = (Button) view.findViewById(R.id.scheduleButton);
        final LinearLayout notice = (LinearLayout) view.findViewById(R.id.notice);

        courseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FragmentCommunityCource());
                fragmentTransaction.commit();
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FragmentCommunity());
                fragmentTransaction.commit();

            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FragmentCommunity());
                fragmentTransaction.commit();
            }
        });

        return view;
    }


}

