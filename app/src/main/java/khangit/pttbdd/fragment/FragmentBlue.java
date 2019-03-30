package khangit.pttbdd.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentBlue extends Fragment {
    MainActivity main;
    Context context = null;
    //String message ="";
    private String items[] = {"Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001"};
    Integer example = R.drawable.ic_launcher_background;
    Integer[] thumbnails =  {example,example,example,example,example,example,example,example,example,example,example};

    public static FragmentBlue newInstance(String strArg){
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1",strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            context = getActivity();
            main = (MainActivity) getActivity();
        }catch(IllegalStateException e){
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue,null);
        final TextView txtBlue = layout_blue.findViewById(R.id.textViewBlue);
        ListView listView =  layout_blue.findViewById(R.id.listViewBlue);
        CustomIconLabelAdapter adapter = new CustomIconLabelAdapter(context,R.layout.custom_row_icon_label,thumbnails,items);
        listView.setAdapter(adapter);
        listView.setSelection(0);
        listView.smoothScrollToPosition(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG","Blue selected row=" + position);
                txtBlue.setText("Blue selected row=" + position);
            }
        });
        return layout_blue;


    }
}
