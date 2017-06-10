package com.anupam.spotsoontask.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anupam.spotsoontask.Adapters.VideoCardAdapter;
import com.anupam.spotsoontask.Model.VideoCardItems;
import com.anupam.spotsoontask.R;

import java.util.ArrayList;

/**
 * Created by Anupam on 10-06-2017.
 */

public class VideoFragment extends Fragment {

    ArrayList<VideoCardItems> videoCardItems;

    ArrayList<Integer> videoImage = new ArrayList<Integer>();
    ArrayList<String> videoTitle = new ArrayList<String>();
    ArrayList<String> videoTime = new ArrayList<String>();
    ArrayList<String> videoDescription = new ArrayList<String>();

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    View view;

    public VideoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_video, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerItems(view);

        return view;
    }

    private void recyclerItems(View view) {

        //Video 1//
        videoImage.add(R.drawable.video1);
        videoTitle.add(getResources().getString(R.string.title1));
        videoTime.add(getResources().getString(R.string.time1));
        videoDescription.add(getResources().getString(R.string.artist1));

        //Video 2//
        videoImage.add(R.drawable.video2);
        videoTitle.add(getResources().getString(R.string.title2));
        videoTime.add(getResources().getString(R.string.time2));
        videoDescription.add(getResources().getString(R.string.artist2));

        //Video 3//
        videoImage.add(R.drawable.video3);
        videoTitle.add(getResources().getString(R.string.title3));
        videoTime.add(getResources().getString(R.string.time3));
        videoDescription.add(getResources().getString(R.string.artist3));

        //Video 4//
        videoImage.add(R.drawable.video4);
        videoTitle.add(getResources().getString(R.string.title4));
        videoTime.add(getResources().getString(R.string.time4));
        videoDescription.add(getResources().getString(R.string.artist4));

        //Video 5//
        videoImage.add(R.drawable.video5);
        videoTitle.add(getResources().getString(R.string.title5));
        videoTime.add(getResources().getString(R.string.time5));
        videoDescription.add(getResources().getString(R.string.artist5));

        videoCardItems = new ArrayList<VideoCardItems>();

            for (int i = 0; i <= videoImage.size()-1; i++) {

                videoCardItems.add(new VideoCardItems(videoImage.get(i), videoTitle.get(i), videoTime.get(i), videoDescription.get(i)));
            }

            recyclerViewAdapter  = new VideoCardAdapter(getActivity(), videoCardItems);
            recyclerView.setAdapter(recyclerViewAdapter);
        }

}