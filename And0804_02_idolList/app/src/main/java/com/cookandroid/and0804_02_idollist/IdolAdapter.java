package com.cookandroid.and0804_02_idollist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class IdolAdapter extends CursorAdapter {
    public IdolAdapter(Context context, Cursor c, boolean autoRequery){
        super(context, c, autoRequery);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item, null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtTel = view.findViewById(R.id.txtNum);

        txtName.setText(cursor.getString(1)); //txtName.setText(cursor.getString(cursor.getColumnIndex("name"));
        txtTel.setText(cursor.getString(2));


    }
}