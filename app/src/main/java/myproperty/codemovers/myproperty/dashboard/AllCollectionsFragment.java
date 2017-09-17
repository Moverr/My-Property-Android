package myproperty.codemovers.myproperty.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.core.BaseFragment;

/**
 * Created by mover on 8/26/2017.
 */

public class AllCollectionsFragment extends BaseFragment {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private static AllCollectionsFragment instance  = null;

    public static AllCollectionsFragment getInstance(){
        if(instance == null ){
            instance = new AllCollectionsFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabbed_activity_main,container,false);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        return view;
      //  return super.onCreateView(inflater, container, savedInstanceState);
    }




}
