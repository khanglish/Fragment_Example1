package khangit.pttbdd.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {
    private Context context;
    private int layoutTobeInflated;
    private List<DATABASE.DbRecord> dbList;

    public CustomBaseAdapter(Context context, int resource, List<DATABASE.DbRecord> dbList){
        this.context = context;
        this.dbList = dbList;
        layoutTobeInflated = resource;
    }

    @Override
    public int getCount() {
        return dbList.size();
    }

    @Override
    public DATABASE.DbRecord getItem(int position) {
        return dbList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;

        View row = convertView;
        if(row == null){
            //LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutTobeInflated,parent,false);
            holder = new MyViewHolder();
            holder.text = row.findViewById(R.id.rowTextView);
            holder.text = row.findViewById(R.id.rowImageView);
            row.setTag(holder);
        }else{
            holder = (MyViewHolder) row.getTag();
        }

        DATABASE.DbRecord dbRec = getItem(position);
        holder.text.setText(dbRec.text);
        holder.img.setImageResource(dbRec.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "IMAGE CLICKED - " + position,Toast.LENGTH_LONG).show();
            }
        });
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"ROW CLICKED - " + position,Toast.LENGTH_SHORT).show();
            }
        });
        return row;
    }//getView

    public class MyViewHolder{
        TextView text;
        ImageView img;
    }
}
