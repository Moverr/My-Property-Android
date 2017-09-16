package myproperty.codemovers.myproperty.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.core.BaseFragment;

/**
 * Created by Manny on 8/29/2017.
 */

public class SignupFragment  extends BaseFragment {

    private static SignupFragment instance = null;

    EditText names,email_address,password,repassword;

    Button register;

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

        names = (EditText) view.findViewById(R.id.names);
        email_address = (EditText) view.findViewById(R.id.email_address);
        password = (EditText) view.findViewById(R.id.password);
        repassword = (EditText) view.findViewById(R.id.repassword);
        register = (Button) view.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });

        return view;

    }

    // plates are done
    private void handleRegister() {
        Toast.makeText(getContext(), "Handler Registration ", Toast.LENGTH_SHORT).show();
    }
}
