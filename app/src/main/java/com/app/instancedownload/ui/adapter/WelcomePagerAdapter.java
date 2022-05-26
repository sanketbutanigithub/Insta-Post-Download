package com.app.instancedownload.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.app.instancedownload.R;
import com.google.android.material.textview.MaterialTextView;

import org.jetbrains.annotations.NotNull;

public class WelcomePagerAdapter extends PagerAdapter {

    private final int[] layouts;
    private Activity activity;

    public WelcomePagerAdapter(Activity activity, int[] layouts) {
        this.activity = activity;
        this.layouts = layouts;
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert layoutInflater != null;
        View view = layoutInflater.inflate(layouts[position], container, false);

        MaterialTextView textView = view.findViewById(R.id.textView_welcome);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (position == 0) {
                textView.setText(activity.getResources().getString(R.string.intro_one_ten));
            } else {
                textView.setText(activity.getResources().getString(R.string.intro_two_ten));
            }
        } else {
            if (position == 0) {
                textView.setText(activity.getResources().getString(R.string.intro_one));
            } else {
                textView.setText(activity.getResources().getString(R.string.intro_two));
            }
        }

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
