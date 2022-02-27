package com.wearedapps.android.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.wearedapps.android.weatherapp.R;
import com.wearedapps.android.weatherapp.response.NextDaysItem;
import com.wearedapps.android.weatherapp.viewholder.WeatherListHolder;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final NextDaysItemClickListener mListener;
    private final Context context;
    private final ArrayList<NextDaysItem> nextDaysItemArrayList;

    public WeatherAdapter(Context context, ArrayList<NextDaysItem> nextDaysItemArrayList
            , NextDaysItemClickListener listener) {
        this.context = context;
        this.nextDaysItemArrayList = nextDaysItemArrayList;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_weather, parent, false);
        return new WeatherListHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((WeatherListHolder) holder).onBind(position, nextDaysItemArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return nextDaysItemArrayList.size();
    }

    public interface NextDaysItemClickListener {

        void onItemClicked(int item);

    }

}