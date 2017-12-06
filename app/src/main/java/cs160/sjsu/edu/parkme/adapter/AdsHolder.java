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
import org.parceler.Parcel;
import org.parceler.Parcels;


public class AdsHolder extends RecyclerView.ViewHolder {

   private TextView addess;
   private ImageView spotImg;
   private TextView price;
   private TextView time;
   private TextView rating;
   private Context mContext;
   private ParkingSpot mParkingSpot;


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

        mParkingSpot = parkingSpot;
        StorageReference storageReference =
                FirebaseStorage.getInstance().getReference()
                        .child("garages");
        addess.setText(parkingSpot.getAddress() + ", " + parkingSpot.getCity());

        spotImg.setImageResource(R.drawable.ic_parking_spot_24);
        rating.setText("Rating" + parkingSpot.getRating() + " / 5");


        if (parkingSpot.getPhotoUrl().equals("") ||
                (parkingSpot.getPhotoUrl() == null)) {
            spotImg.setImageResource(R.drawable.ic_parking_spot_24);
        } else {
            int index = parkingSpot.getPhotoUrl().lastIndexOf("/");
            String imageName = parkingSpot.getPhotoUrl().substring(
                    index+1
            );
            GlideApp.with(mContext)
                    .load(storageReference.child(imageName))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(spotImg);
        }

        String timeSlot = parkingSpot.getStartDate() + " " + parkingSpot.getStartTime()
                + " -- " + parkingSpot.getEndDate() + " " + parkingSpot.getEndTime();
        time.setText(timeSlot);
        price.setText("Price: " + parkingSpot.getDailyRate() + " hourly");
    }

}
