package com.example.android.mobiwik;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;

import java.util.List;

public class CustomAdapter extends BaseAdapter{
    private final static String TAG = CustomAdapter.class.getSimpleName();

    private Context activity;
    private LayoutInflater inflater = null;
    private List<Mobile> mobile;
    int layout;

    public CustomAdapter(Context activity, List<Mobile> Student) {


        this.activity = activity;
        this.mobile = Student;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return mobile.size();
    }

    @Override
    public Object getItem(int position) {
        return mobile.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public  class ViewHolder {
        //ImageView imageView ;
        TextView name  ;
        TextView usn ;
        ParseImageView imageView;
        TextView semester;
        TextView camera;
        TextView memory;
        TextView r2;
        TextView weight;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View v =view;
        ViewHolder holder = new ViewHolder();

        if (view == null) {
            LayoutInflater li = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.list_item_layout,null);
            holder.name = (TextView)v.findViewById(R.id.product_name);
            holder.usn = (TextView)v.findViewById(R.id.product_brand);
            holder.semester = (TextView)v.findViewById(R.id.product_camera);
            holder.camera=(TextView)v.findViewById(R.id.product_price);
            holder.imageView = (ParseImageView)v.findViewById(R.id.imageView);

            /*holder.memory=(TextView)v.findViewById(R.id.memory);
            holder.r2=(TextView)v.findViewById(R.id.r1);
            /*holder.weight=(TextView)v.findViewById(R.id.weight);*/
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        Mobile s = new Mobile();

        s = mobile.get(position);
        String a =  s.Name;
        Log.d(TAG,a);
        holder.name.setText(s.getName());
        holder.usn.setText(s.getPrice());
        holder.semester.setText(s.getBrand());
        holder.camera.setText(s.getCamera());
        ParseFile imageFile = s.getImage();
        if(imageFile != null)
        {
            holder.imageView.setParseFile(imageFile);
            holder.imageView.loadInBackground();
        }
       /* holder.memory.setText(s.getMemory());
        holder.r2.setText(s.getRAM());
       /* holder.weight.setText(s.getWeight());*/

        Log.d("CustomAdapter.class", "CustomAdapter");

        // imageView.setImageDrawable(s.getPic());
        return v;
    }


}