package com.example.monagarg.mhmapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by monagarg on 01/06/17.
 */

public class AdapterGrid extends BaseAdapter {
    String nameList[];
    int name[];
    private Context mContext;


    public AdapterGrid(Context c,String[] nameList, int[] name) {
        this.nameList=nameList;
        this.name=name;
        mContext = c;
    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view=inflater.inflate(R.layout.content_item,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView txt=(TextView)view.findViewById(R.id.textView);
        txt.setText(nameList[position]);
        imageView.setImageResource(name[position]);
        view.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        mContext.startActivity(new Intent(mContext,Gallary.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext,ContactUs.class));
                        break;

                    case 2:
                        mContext.startActivity(new Intent(mContext,Events.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext,Register.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent());
                        break;
                  case 5:
                        mContext.startActivity(new Intent(mContext,Broadcast.class));
                        break;
                }
            }
        });

        return view;
    }
}
