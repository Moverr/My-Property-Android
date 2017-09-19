package myproperty.codemovers.myproperty.dashboard.customer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

        String[] values_ = new String[list.size()];

        StableArrayAdapter  adapter = new StableArrayAdapter(getContext(),android.R.layout.simple_list_item_1,list.toArray(values_));
        listView.setAdapter(adapter);

        return rootView;
    }

    public class StableArrayAdapter extends  ArrayAdapter<String>{
//        HashMap<String, Integer> mIdMap = new HashMap<>();
//
//        public StableArrayAdapter(Context context, int textViewResourceId,
//                                  List<String> objects) {
//            super(context, textViewResourceId, objects);
//            for (int i = 0; i < objects.size(); ++i) {
//                mIdMap.put(objects.get(i), i);
//            }
//        }
//
//
//        @Override
//        public long getItemId(int position) {
//            String item = getItem(position);
//            return mIdMap.get(item);
//        }
//
//        @Override
//        public boolean hasStableIds() {
//            return  true;
//        }


        private final Context context;
        private final String[] values;

        public StableArrayAdapter(Context context,int resourceId, String[] objects) {
            super(context, resourceId, objects);
            this.context = context;
            values = new String[objects.length];



            for(int i = 0; i < objects.length; i ++ ){
                values[i] = objects[i];
            }
          //  this.values = values;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item_view, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView.setText(values[position]);
            // change the icon for Windows and iPhone
            String s = values[position];
            if (s.startsWith("iPhone")) {
                imageView.setImageResource(R.drawable.ic_menu_camera);
            } else {
                imageView.setImageResource(R.drawable.ic_menu_manage);
            }

            return rowView;
        }

    }



}
