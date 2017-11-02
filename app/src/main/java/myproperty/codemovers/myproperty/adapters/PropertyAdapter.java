package myproperty.codemovers.myproperty.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.response.Property;

/**
 * Created by Mover on 10/8/2017.
 */

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.ViewHolder> {

    private List<Property> mProperties;
    private Context mContext;

    public PropertyAdapter(Context context, List<Property> properties) {
        this.mProperties = properties;
        this.mContext = context;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public PropertyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the Custom Layout
        View propertyView = inflater.inflate(R.layout.list_item_view, parent, false);

        //Return a New Holder Instance
        ViewHolder viewHolder = new ViewHolder(propertyView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Property property = mProperties.get(position);
        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(property.getBrief());

        textView = holder.typeTextView;
        textView.setText("TYPE : ".concat(property.getProperty_type()));

       // textView = holder.amountTextView;
       // textView.setText("SIZE  : ".concat(property.get()));



    }

    @Override
    public int getItemCount() {
        return mProperties.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView typeTextView;
        public TextView amountTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.headerText);
            nameTextView.setTextSize(20);

            typeTextView = (TextView) itemView.findViewById(R.id.property_type);
            amountTextView = (TextView) itemView.findViewById(R.id.amount_and_currency);

            //  messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }

}
