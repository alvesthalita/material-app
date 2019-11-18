package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.androidquery.AQuery;
import com.example.myapplication.core.web.entities.MaterialResult;

public class MaterialAdapter extends BaseAdapter {

    private Context context;
    private MaterialResult[] materialItem;

    public MaterialAdapter(Context context, MaterialResult[] materialItem) {
        this.context = context;
        this.materialItem = materialItem;
    }

    @Override
    public int getCount() {
        return materialItem.length;
    }

    @Override
    public Object getItem(int position) {
        return materialItem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_material_list, parent, false);
        }

        AQuery aq = new AQuery(convertView);
        MaterialResult item = materialItem[position];

        aq.id(R.id.tv_item_name).text(item.getName());
        aq.id(R.id.tv_stock).text(item.getStock());
        aq.id(R.id.tv_price).text(item.getPrice());

        switch (item.getName()){
            case "Pencil":
                aq.id(R.id.iv_item).image(R.drawable.pencil);
                break;
            case "Rubberbands":
                aq.id(R.id.iv_item).image(R.drawable.rubberbands);
                break;
            case "Rulers":
                aq.id(R.id.iv_item).image(R.drawable.rulers);
                break;
            case "Clock":
                aq.id(R.id.iv_item).image(R.drawable.clock);
                break;
            default:
                aq.id(R.id.iv_item).image(R.drawable.error_circle);
                break;
        }

        return convertView;
    }
}
