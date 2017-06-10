package com.anupam.spotsoontask.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anupam.spotsoontask.R;
import com.anupam.spotsoontask.Model.VideoCardItems;

import java.util.ArrayList;

/**
 * Created by Anupam on 10-06-2017.
 */

public class VideoCardAdapter extends RecyclerView.Adapter<VideoCardAdapter.ViewHolder>{

    public ArrayList<VideoCardItems> videoCardItemses;
    Context context;

    public VideoCardAdapter(Context context, ArrayList<VideoCardItems> videoCardItemses) {
        this.videoCardItemses = videoCardItemses;
        this.context = context;
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

    @Override
    public VideoCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        itemLayoutView.setOnClickListener(onClickListener);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final ImageView imageViewImage = (ImageView) viewHolder.image.findViewById(R.id.video_image);
        final TextView textViewTitle = (TextView) viewHolder.title.findViewById(R.id.video_title);
        final TextView textViewTime = (TextView) viewHolder.time.findViewById(R.id.video_time);
        final TextView textViewDesc = (TextView) viewHolder.description.findViewById(R.id.video_description);

        textViewTitle.setText(videoCardItemses.get(position).getTitle());
        textViewTime.setText(videoCardItemses.get(position).getTime());
        textViewDesc.setText(videoCardItemses.get(position).getDescription());
        imageViewImage.setImageResource(videoCardItemses.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return videoCardItemses.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView title;
        public TextView time;
        public TextView description;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            image = (ImageView) itemLayoutView .findViewById(R.id.video_image);
            title = (TextView) itemLayoutView.findViewById(R.id.video_title);
            time = (TextView) itemLayoutView.findViewById(R.id.video_time);
            description = (TextView) itemLayoutView.findViewById(R.id.video_description);

        }
    }
}

