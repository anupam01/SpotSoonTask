package com.anupam.spotsoontask.Utils;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anupam.spotsoontask.R;

/**
 * Created by Anupam on 09-06-17.
 */
public class ViewPagerAdapder extends PagerAdapter {
    Context context;
    int image[];
    int videoName[];
    int artistName[];

    LayoutInflater inflater;

    public ViewPagerAdapder(Context context, int[] imgArray, int[] videoTitle, int[] artists) {
        this.context = context;
        this.image = imgArray;
        this.videoName = videoTitle;
        this.artistName = artists;
    }

    public int getCount() {
        return image.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        ImageView imgBanner;
        TextView txtTitle;
        TextView txtArtist;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_items, container,
                false);

        // Locate the ImageView in viewpager_item.xml
        imgBanner = (ImageView) itemView.findViewById(R.id.banner_image);
        // Capture position and set to the ImageView
        imgBanner.setBackgroundResource(image[position]);

        // Locate the TextViews in viewpager_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.video_title);
        txtArtist = (TextView) itemView.findViewById(R.id.video_artist);

        // Capture position and set to the TextViews
        txtTitle.setText(videoName[position]);
        txtArtist.setText(artistName[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}