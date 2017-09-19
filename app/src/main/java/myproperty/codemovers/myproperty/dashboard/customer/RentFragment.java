package myproperty.codemovers.myproperty.dashboard.customer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.core.BaseFragment;


/**
 * Created by mover on 9/17/2017.
 */

public class RentFragment  extends BaseFragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public RentFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RentFragment newInstance(int sectionNumber) {
        RentFragment fragment = new RentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        //View rootView = inflater.inflate(R.layout.list_view, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.txt);
//        textView.setText("JUA KALI");

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };


        ListView listView = (ListView) rootView.findViewById(R.id.listview);

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < values.length; i ++ ){
            list.add(values[i]);
        }

        StableArrayAdapter  adapter = new StableArrayAdapter(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


//        ArrayList<String> list = new ArrayList<>();
//
//        for(int x = 0; x < values.length; x ++ ){
//            list.add(values[x]);
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_view,list);
//



//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        return rootView;
    }

    public class StableArrayAdapter extends  ArrayAdapter<String>{
        HashMap<String, Integer> mIdMap = new HashMap<>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }


        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return  true;
        }
    }



}
