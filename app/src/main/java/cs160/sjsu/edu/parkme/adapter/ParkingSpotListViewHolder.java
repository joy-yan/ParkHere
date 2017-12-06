package cs160.sjsu.edu.parkme.adapter;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;


import java.io.IOException;

import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.utils.Constants;
import cs160.sjsu.edu.parkme.utils.ImageStreamingUtil;

public class ParkingSpotListViewHolder extends RecyclerView.ViewHolder
        implements ParkingSpotTouchHelperViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;
    ParkingSpot mItem;


    public ParkingSpotListViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindView(ParkingSpot item) {

        ImageView mItemImageView = (ImageView) mView.findViewById(R.id.parkSpotImageView);
        TextView textViewItemTime = (TextView) mView.findViewById(R.id.parkSpotTimeSlot);
        TextView textViewItemLoc = (TextView) mView.findViewById(R.id.parkSpotAddress);
//        ImageStreamingUtil.downloadFromFirebaseStorage(mContext,
//                FirebaseStorage.getInstance().getReference().child(Constants.FIREBASE_STORAGE_PARKINGSPOT_PHOTOS +item.getPhotoUrl()), mItemImageView);

        String timeSlot = item.getStartDate() + " at " + item.getStartTime()
                + " -- " + item.getEndDate() + " at " + item.getEndTime();
        textViewItemTime.setText(timeSlot);
        textViewItemLoc.setText(item.getAddress());
        mItem = item;
    }


    public static Bitmap decodeFromFirebaseBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }

    @Override
    public void onItemSelected() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_on);
        set.setTarget(itemView);
        set.start();
    }

    @Override
    public void onItemClear() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();
    }


}

