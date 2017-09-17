package myproperty.codemovers.myproperty.dashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import myproperty.codemovers.myproperty.dashboard.customer.RentFragment;


/**
 * Created by mover on 9/17/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                return  RentFragment.newInstance(position + 1);
            case 1:
                return  PlaceholderFragment.newInstance(position + 1);
            default:
                return  PlaceholderFragment.newInstance(position + 1);
        }
      //  return  PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Rent";
            case 1:
                return "Buy";
            case 2:
                return "Check-in";
        }
        return null;
    }
}
