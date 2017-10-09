package myproperty.codemovers.myproperty.dashboard.customer;

import android.graphics.Bitmap;

/**
 * Created by Manny on 10/8/2017.
 */

public class Bakery {

    public String bakeryName;
    public String description;
    public String phoneNumber;
    public String websiteUrl;
    public String address;
    public Bitmap logo;


    public Bakery(String bakeryName,
                  String description,
                  String phoneNumber,
                  String websiteUrl,
                  String address) {

        this.bakeryName = bakeryName;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.websiteUrl = websiteUrl;
    }



}
