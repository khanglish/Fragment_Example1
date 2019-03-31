package khangit.pttbdd.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FragmentBlue extends Fragment {
    MainActivity main;
    Context context = null;
    //String message ="";

    private String items[] = {"Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001","Text  001"};

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
        ListView listView =  layout_blue.findViewById(R.id.list);
        // List database = new DATABASE().dbList;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

        listView.setSelection(0);
        listView.smoothScrollToPosition(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG","Blue selected row=" + position);
                txtBlue.setText("Blue selected row=" + position);
            }
        });
        return layout_blue;


    }
}
