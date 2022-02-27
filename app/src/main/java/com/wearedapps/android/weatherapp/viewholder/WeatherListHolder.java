package com.wearedapps.android.weatherapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wearedapps.android.weatherapp.R;
import com.wearedapps.android.weatherapp.adapter.WeatherAdapter;
import com.wearedapps.android.weatherapp.response.NextDaysItem;

public class WeatherListHolder extends BaseViewHolder implements View.OnClickListener {

    View itemView;
    WeatherAdapter.NextDaysItemClickListener listener;
    private ImageView image;
    private TextView tvDays;
    private TextView tvComments;

    public WeatherListHolder(View itemView, WeatherAdapter.NextDaysItemClickListener mListener) {
        super(itemView);
        this.itemView = itemView;
        this.listener = mListener;

        image = itemView.findViewById(R.id.image);
        tvComments = itemView.findViewById(R.id.tvComments);
        tvDays = itemView.findViewById(R.id.tvDays);
    }

    @Override
    public void onBind(int position, Object object) {

        NextDaysItem nextDays = (NextDaysItem) object;

        tvComments.setText(nextDays.getComment());
        tvDays.setText(nextDays.getDay());

        Glide.with(image.getContext()).load(nextDays.getIconURL()).into(image);

        image.setOnClickListener(this);
        image.setTag(position);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClicked(Integer.parseInt(v.getTag().toString()));
    }
}

