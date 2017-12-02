package cs160.sjsu.edu.parkme.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.MainActivity;
import cs160.sjsu.edu.parkme.utils.Constants;

/**
 * Created by joyyan on 12/2/17.
 */

public class FirebaseParkingAdsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseParkingAdsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindAdsPost(ParkingSpot parkingSpot) {
        ImageView parkingSpotImageView = (ImageView) mView.findViewById(R.id.parkSpotImageView);
        TextView descTextView = (TextView) mView.findViewById(R.id.parkSpotDesc);
        TextView addressTextView = (TextView) mView.findViewById(R.id.parkSpotAddress);
      //  TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.with(mContext)
                .load(parkingSpot.getPhotoUrl())
                .placeholder(R.drawable.ic_parking_spot_24)
                .error(R.drawable.ic_parking_spot_24)
                .resizeDimen(R.dimen.list_detail_image_size, R.dimen.list_detail_image_size)
                .centerInside()
                .into(parkingSpotImageView);


        addressTextView.setText(parkingSpot.getAddress());
        descTextView.setText(parkingSpot.getDescription());
        //ratingTextView.setText("Rating: " + parkingSpot.getRating() + "/5");
    }

    @Override
    public void onClick(View view) {
        final ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                .child("users").child("ads");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    parkingSpots.add(snapshot.getValue(ParkingSpot.class));
                }

                int itemPosition = getLayoutPosition();

                Fragment ownerFragment = ((MainActivity) mContext)
                        .getSupportFragmentManager().findFragmentByTag("owner_fragment");

                Bundle bundle = new Bundle();
                bundle.putInt("position", itemPosition);
                bundle.putParcelable("selectedSpot", Parcels.wrap(parkingSpots));
                ownerFragment.setArguments(bundle);

                FragmentTransaction transaction = ((MainActivity) mContext).getSupportFragmentManager().beginTransaction();

                transaction.replace(android.R.id.content, ownerFragment); //also crashes with R.id.main_fragmentcontainer
                transaction.commit();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
