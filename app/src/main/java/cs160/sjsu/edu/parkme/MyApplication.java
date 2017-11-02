package cs160.sjsu.edu.parkme;

/**
 * Created by joyyan on 5/25/17.
 */


import android.app.Application;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

import cs160.sjsu.edu.parkme.model.ParkingSpot;

/**
 * Created by joyyan on 4/6/17.
 */

public class MyApplication extends Application {
    private static MyApplication singleton;

    private GoogleApiClient mGoogleApiClient;

    private ArrayList<ParkingSpot> ParkingSpotsInCart;

    public static synchronized MyApplication getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        super.onCreate();
        ParkingSpotsInCart = new ArrayList<ParkingSpot>();
        /* Enable disk persistence  */
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public GoogleApiClient getmGoogleApiClient() {
        return mGoogleApiClient;
    }

    public void setmGoogleApiClient(GoogleApiClient mGoogleApiClient) {
        this.mGoogleApiClient = mGoogleApiClient;
    }

    public ArrayList<ParkingSpot> getParkingSpotsInCart() {
        return ParkingSpotsInCart;
    }

    public boolean hasParkingSpotInCart(ParkingSpot item) {
        for (ParkingSpot ParkingSpot : ParkingSpotsInCart) {
            if (ParkingSpot.equals(item)) return true;
        }
        return false;
    }
}



