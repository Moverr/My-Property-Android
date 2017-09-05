package myproperty.codemovers.myproperty.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.core.BaseFragment;

/**
 * Created by Manny on 8/26/2017.
 */

public class ExampleFragment extends BaseFragment {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
//fragment_sample
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.tabbed_activity_main,container,false);
        return  view;
    }
}
