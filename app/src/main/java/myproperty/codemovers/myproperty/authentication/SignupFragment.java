package myproperty.codemovers.myproperty.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.core.FragmentBase;

/**
 * Created by Manny on 8/29/2017.
 */

public class SignupFragment  extends FragmentBase {

    private static SignupFragment instance = null;

    public static SignupFragment getInstance(){
        if(instance == null){
            instance = new SignupFragment();
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
        View view = inflater.inflate(R.layout.signup_screen,container,false);
        return view;

    }
}
