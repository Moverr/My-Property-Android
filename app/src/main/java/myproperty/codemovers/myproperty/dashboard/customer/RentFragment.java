package myproperty.codemovers.myproperty.dashboard.customer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.adapters.PropertyAdapter;
import myproperty.codemovers.myproperty.api.services.IResult;
import myproperty.codemovers.myproperty.connector.PropertyConnector;
import myproperty.codemovers.myproperty.core.BaseFragment;
import myproperty.codemovers.myproperty.response.Property;
import myproperty.codemovers.myproperty.response.PropertySizeResponse;


/**
 * Created by mover on 9/17/2017.
 */

public class RentFragment extends BaseFragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    IResult mResultCallback;
    private PropertyConnector propertyConnector;
    private Property property;
    private List<Property> properties = new ArrayList<>();
    private RecyclerView recyclerView;
    private Context mContext;
    private Activity mActivity;


    public RentFragment() {
        propertyConnector = propertyConnector.getInstance();

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycle_view, container, false);
        mContext = this.getContext();
        mActivity = this.getActivity();

        //if (properties == null) {
            getPropertyList();
      //  }

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        ArrayList<String> list = new ArrayList<>();

        if (properties != null) {

            for (Property property : properties) {
                list.add(property.getBrief());
            }
        }

        PropertyAdapter _adapter = new PropertyAdapter(this.getContext(), properties);
        recyclerView.setAdapter(_adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return rootView;
    }


    public void getPropertyList() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, String response) {
                try {
                    //update
                    Toast.makeText(getContext(), "DID YOu KNOW ME SUCCESS ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();


                    property = new Property();
                    JSONArray property_list = new JSONArray(response);

                    int counter = 0;
                    while (counter < property_list.length()) {

                        Property property = new Property();

                        JSONObject propertyObject = property_list.getJSONObject(counter);
                        Integer id = propertyObject.getInt("id");
                        property.setId(id);

                        //todo: convert from String to date
//                        String date_created = propertyObject.getString("dateCreated");
//                        if (date_created != null)
//                            property.setDateCreated(Utilities.convertTimeFromMilli(Integer.parseInt(date_created)));
//                        //todo: convert from String to date
//                        String dateUpdated = propertyObject.getString("dateUpdated");
//                        if (dateUpdated != null)
//                            property.setDateUpdated(Utilities.convertTimeFromMilli(Integer.parseInt(dateUpdated)));


                        String brief = propertyObject.getString("brief");
                        property.setBrief(brief);
                        String details = propertyObject.getString("details");
                        property.setDetails(details);
                        String accountId = propertyObject.getString("accountId");
                        if (accountId != null)
                            property.setAccountId(Integer.parseInt(accountId));
                        Integer userId = propertyObject.getInt("userId");
                        // property.setUserId(userId);

                        String property_type = propertyObject.getString("property_type");
                        property.setProperty_type(property_type);

                        ArrayList<PropertySizeResponse> _propertySizeResponses = new ArrayList<>();


                        Object propertySizeObject = propertyObject.get("propertySizeResponses");
                        if (propertySizeObject instanceof JSONArray) {
                            JSONArray propertySizeResponses = propertyObject.getJSONArray("propertySizeResponses");
                            int x = 0;

                            if (propertySizeResponses != null && propertySizeResponses.length() > 0) {
                                while (x < propertySizeResponses.length()) {
                                    JSONObject _propertySizeResponseObject = propertySizeResponses.getJSONObject(x);
                                    PropertySizeResponse propertySizeResponse = new PropertySizeResponse();
                                    propertySizeResponse.setId(_propertySizeResponseObject.getInt("id"));
                                    propertySizeResponse.setSize(_propertySizeResponseObject.getString("size"));
                                    propertySizeResponse.setUnitMeasure(_propertySizeResponseObject.getString("unitMeasure"));
                                    _propertySizeResponses.add(propertySizeResponse);
                                    x++;
                                }
                            }

                        }
                        PropertySizeResponse[] propertySizeResponses = new PropertySizeResponse[_propertySizeResponses.size()];
                        property.setPropertySizeResponses(_propertySizeResponses.toArray(propertySizeResponses));


                        String location = propertyObject.getString("location");
                        property.setLocation(location);
                        String lat = propertyObject.getString("lat");
                        property.setLat(lat);
                        String lng = propertyObject.getString("lng");
                        property.setLng(lng);

                        properties.add(property);

                        counter++;

                    }

                    //todo : add data to view

                    PropertyAdapter _adapter = new PropertyAdapter(mContext, properties);
                    recyclerView.setAdapter(_adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

                    //todo: add data to the database ::


                } catch (Exception em) {
                    Log.getStackTraceString(em.fillInStackTrace());
                    Toast.makeText(getContext(), "Something went wrongn" + em.getMessage(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getContext(), "Something went wrongn" + em.getMessage(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                Toast.makeText(getContext(), "DID YOu KNOW ME ERROR ", Toast.LENGTH_SHORT).show();
            }
        };

        propertyConnector.getPropertyList(getContext(), mResultCallback);
    }


}
