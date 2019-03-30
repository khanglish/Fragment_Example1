package khangit.pttbdd.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomIconLabelAdapter extends ArrayAdapter<String> {
    Context context;
    Integer[] thumbnails;
    String[] items;
    private final int newsItemLayoutResource;

    public CustomIconLabelAdapter(final Context context, final int newsItemLayoutResource,Integer[] thumbnails, String[] items){
        super(context,0);
        this.context = context;
        this.newsItemLayoutResource = newsItemLayoutResource;
        this.thumbnails = thumbnails;
        this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_row_icon_label, null);
        TextView label = (TextView) row.findViewById(R.id.label);
        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        label.setText(items[position]);
        icon.setImageResource(thumbnails[position]);
        return (row);
    }
}// CustomAdapter