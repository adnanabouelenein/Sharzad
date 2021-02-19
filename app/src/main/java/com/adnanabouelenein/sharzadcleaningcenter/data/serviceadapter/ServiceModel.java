package com.adnanabouelenein.sharzadcleaningcenter.data.serviceadapter;

import android.os.Parcel;
import android.os.Parcelable;

public class ServiceModel {


    private String serviceName;
    private int price;
    private int serviceImage;

    public ServiceModel(String serviceName, int price, int serviceImage) {
        this.serviceName = serviceName;
        this.price = price;
        this.serviceImage = serviceImage;
    }


    public String getServiceName() {
        return serviceName;
    }

    public int getPrice() {
        return price;
    }

    public int getServiceImage() {
        return serviceImage;
    }



}
