package myproperty.codemovers.myproperty.core.util;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mover on 9/5/2017.
 */

public class Toaster {
    public static final int INDEFINITE = Snackbar.LENGTH_INDEFINITE;
    public static final int LONG = Snackbar.LENGTH_LONG;
    public static final int SHORT = Snackbar.LENGTH_SHORT;

    public static void show(View view, String text, int duration){
      final Snackbar snackbar = Snackbar.make(view,text, duration);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(12);
        snackbar.setAction("OK",new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
    public static void show(View view, int res, int duration){

    }

    public static void show(View view, String text){
        show(view,text,Snackbar.LENGTH_LONG);
    }

    public static void show(View view, int res){

    }
}
