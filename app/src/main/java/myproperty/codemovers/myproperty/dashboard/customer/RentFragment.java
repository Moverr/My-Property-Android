package myproperty.codemovers.myproperty.dashboard.customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.core.BaseFragment;
import myproperty.codemovers.myproperty.dashboard.PlaceholderFragment;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
        //View rootView = inflater.inflate(R.layout.list_view, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.txt);
        textView.setText("JUA KALI");

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };


        ArrayList<String> list = new ArrayList<>();

        for(int x = 0; x < values.length; x ++ ){
            list.add(values[x]);
        }



//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        return rootView;
    }
}
