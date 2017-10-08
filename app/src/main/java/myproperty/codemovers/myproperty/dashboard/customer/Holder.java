package myproperty.codemovers.myproperty.dashboard.customer;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Manny on 10/8/2017.
 */

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
//    private final ImageView bakeryLogo;
//    private final TextView bakeryName;
//    private final TextView address;
//    private final TextView description;
//    private final TextView phone;
//    private final TextView website;

    private Context context;

    public Holder(Context context, View itemView) {

        super(itemView);
        this.context = context;

        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
