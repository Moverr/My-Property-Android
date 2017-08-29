package myproperty.codemovers.myproperty.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.commons.FragmentBase;

/**
 * Created by Manny on 8/29/2017.
 */

public class LoginFragment extends FragmentBase {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_screen,container,false);
        return view;

    }
}
