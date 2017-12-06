package cs160.sjsu.edu.parkme.adapter;

/**
 * Created by joyyan on 12/5/17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.DetailActivity;
import cs160.sjsu.edu.parkme.utils.ImageStreamingUtil;

import org.parceler.Parcel;
import org.parceler.Parcels;


public class AdsHolder extends RecyclerView.ViewHolder {

   private TextView addess;
   private ImageView spotImg;
   private TextView price;
   private TextView time;
   private TextView rating;
   private Context mContext;


    public AdsHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;
       addess = itemView.findViewById(R.id.parkSpotAddress);
       spotImg = itemView.findViewById(R.id.parkSpotImageView);
       price = itemView.findViewById(R.id.parkSpotPrice);
       time = itemView.findViewById(R.id.parkSpotTimeSlot);
       rating = itemView.findViewById(R.id.parkSpotRating);

    }

    public void bind(ParkingSpot parkingSpot) {


        addess.setText(parkingSpot.getAddress() + ", " + parkingSpot.getCity());
        rating.setText("Rating" + parkingSpot.getRating() + " / 5");

        ImageStreamingUtil.loadImage(mContext, spotImg, parkingSpot.getPhotoUrl());

        String timeSlot = parkingSpot.getStartDate() + " " + parkingSpot.getStartTime()
                + " -- " + parkingSpot.getEndDate() + " " + parkingSpot.getEndTime();
        time.setText(timeSlot);
        price.setText("Price: " + parkingSpot.getDailyRate() + " hourly");
    }


}
