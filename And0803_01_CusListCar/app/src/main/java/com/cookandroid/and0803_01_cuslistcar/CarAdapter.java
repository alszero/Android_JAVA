package com.cookandroid.and0803_01_cuslistcar;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {
    Context context;
    ArrayList<CAR> data;

    public CarAdapter(Context context, ArrayList<CAR> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();//배열 원소의 개수
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){ //초기화
            view = View.inflate(context, R.layout.listitem, null);
        }
        ImageView img = view.findViewById(R.id.imgPoster);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        img.setImageDrawable(data.get(i).getImage()); //Movie의 image 변수값 가져와서 연결
        txtTitle.setText(data.get(i).getTitle()); //Movie의 title값 가져와서 연결

        return view;
    }
}
