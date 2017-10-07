package myproperty.codemovers.myproperty.dashboard.customer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.api.services.IResult;
import myproperty.codemovers.myproperty.connector.PropertyConnector;
import myproperty.codemovers.myproperty.core.BaseFragment;
import myproperty.codemovers.myproperty.response.PropertyResponse;
import myproperty.codemovers.myproperty.response.PropertySizeResponse;


/**
 * Created by mover on 9/17/2017.
 */

public class RentFragment extends BaseFragment {

    private PropertyConnector propertyConnector;
    PropertyResponse propertyResponse;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    IResult mResultCallback;

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
        Toast.makeText(getContext(), "FIRST TESTER", Toast.LENGTH_SHORT).show();

        getPropertyList();
        // get the most important data :: structure
    }


    public void getPropertyList() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, String response) {
                try {
                    //update
                    Toast.makeText(getContext(), "DID YOu KNOW ME SUCCESS ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();

                    propertyResponse = new PropertyResponse();
                    JSONArray property_list = new JSONArray(response);

                    int counter = 0;
                    while (counter < property_list.length()) {

                        JSONObject propertyObject = property_list.getJSONObject(counter);
                        Integer id = propertyObject.getInt("id");
                        //todo: convert from String to date
                        String date_created = propertyObject.getString("dateCreated");
                        //todo: convert from String to date
                        String dateUpdated = propertyObject.getString("dateUpdated");
                        String brief = propertyObject.getString("brief");
                        String details = propertyObject.getString("details");
                        String accountId = propertyObject.getString("accountId");
                        Integer userId = propertyObject.getInt("userId");
                        String property_type = propertyObject.getString("property_type");

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

                        String location = propertyObject.getString("location");
                        String lat = propertyObject.getString("lat");
                        String lng = propertyObject.getString("lng");




                        counter++;

                    }

                    // Date dateCreated =  new Date(propertyObject.getString("dateCreated"));


//                    Integer id = jsonObject.getInt("id");
////                    Date dateCreated =  new Date(jsonObject.getString("dateCreated"));
////                    Date dateUpdated =  new Date(jsonObject.getString("dateUpdated"));
////
//
//                    String brief = jsonObject.getString("brief");
//                    String details = jsonObject.getString("details");
//                    Integer accountId = jsonObject.getInt("accountId");
//                    Integer userId = jsonObject.getInt("userId");
//                    String property_type = jsonObject.getString("property_type");


//                    ArrayList<PropertySizeResponse> _propertySizeResponses = new ArrayList<>();
//                    JSONArray propertySizeResponses = jsonObject.getJSONArray("propertySizeResponses");

//                    int x = 0;
//                    while(x < propertySizeResponses.length()){
//                        JSONObject _propertySizeResponseObject = propertySizeResponses.getJSONObject(x);
//                        PropertySizeResponse propertySizeResponse = new PropertySizeResponse();
//                        propertySizeResponse.setId(_propertySizeResponseObject.getInt("id"));
//                        propertySizeResponse.setSize(_propertySizeResponseObject.getString("size"));
//                        propertySizeResponse.setUnitMeasure(_propertySizeResponseObject.getString("unitMeasure"));
//                        _propertySizeResponses.add(propertySizeResponse);
//                        x ++;
//                    }

//                      String location = jsonObject.getString("location");
//                      String lat = jsonObject.getString("lat");
//                      String lng = jsonObject.getString("lng");


//                    Integer id = jsonObject.getInt("id");
//                    Integer id = jsonObject.getInt("id");
//                    Integer id = jsonObject.getInt("id");
//                    Integer id = jsonObject.getInt("id");
//

                    /*
                     private String brief;
    private String status;
    private String details;
    private Integer accountId;
    private Integer userId;
    private String property_type;

    private PropertySizeResponse[] propertySizeResponses;

    private String location;
    private String lat;
    private String lng;


                     */


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        //View rootView = inflater.inflate(R.layout.list_view, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.txt);
//        textView.setText("JUA KALI");

        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};


        ListView listView = (ListView) rootView.findViewById(R.id.listview);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        String[] values_ = new String[list.size()];

        StableArrayAdapter adapter = new StableArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list.toArray(values_));
        listView.setAdapter(adapter);

        return rootView;
    }

    public class StableArrayAdapter extends ArrayAdapter<String> {
//        HashMap<String, Integer> mIdMap = new HashMap<>();
//
//        public StableArrayAdapter(Context context, int textViewResourceId,
//                                  List<String> objects) {
//            super(context, textViewResourceId, objects);
//            for (int i = 0; i < objects.size(); ++i) {
//                mIdMap.put(objects.get(i), i);
//            }
//        }
//
//
//        @Override
//        public long getItemId(int position) {
//            String item = getItem(position);
//            return mIdMap.get(item);
//        }
//
//        @Override
//        public boolean hasStableIds() {
//            return  true;
//        }


        private final Context context;
        private final String[] values;

        public StableArrayAdapter(Context context, int resourceId, String[] objects) {
            super(context, resourceId, objects);
            this.context = context;
            values = new String[objects.length];


            for (int i = 0; i < objects.length; i++) {
                values[i] = objects[i];
            }
            //  this.values = values;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item_view, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.secondLine);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView.setText(values[position]);
            // change the icon for Windows and iPhone
            String s = values[position];
            if (s.startsWith("iPhone")) {
                imageView.setImageResource(R.drawable.ic_menu_camera);
            } else {
                imageView.setImageResource(R.drawable.ic_menu_manage);
            }

            return rowView;
        }

    }


}
