package com.app.instancedownload.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.app.instancedownload.R;
import com.app.instancedownload.ui.activity.VideoPlayer;
import com.app.instancedownload.util.TouchImageView;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class ShowAdapter extends PagerAdapter {

    private Activity activity;
    private String type;
    private List<File> string;

    public ShowAdapter(Activity activity, List<File> string, String type) {
        this.activity = activity;
        this.string = string;
        this.type = type;
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.show_adapter, container, false);

        TouchImageView touchImageView = view.findViewById(R.id.imageView_image_show_adapter);
        ImageView imageViewPlay = view.findViewById(R.id.imageView_play);

        if (type.equals("image")) {
            imageViewPlay.setVisibility(View.GONE);
        } else if (type.equals("all")) {
            if (string.get(position).toString().contains(".jpg")) {
                imageViewPlay.setVisibility(View.GONE);
            }
        }

        imageViewPlay.setOnClickListener(v -> activity.startActivity(new Intent(activity, VideoPlayer.class)
                .putExtra("link", string.get(position).toString())));

        Glide.with(activity).load(string.get(position).toString())
                .placeholder(R.drawable.place_holder)
                .into(touchImageView);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return string.size();
    }

    @Override
    public int getItemPosition(@NotNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
        container.removeView((View) object);
    }
}

