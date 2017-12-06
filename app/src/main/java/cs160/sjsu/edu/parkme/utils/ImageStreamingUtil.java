package cs160.sjsu.edu.parkme.utils;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.adapter.GlideApp;

/**
 * Created by joyyan on 4/7/17.
 */

public class ImageStreamingUtil {

    private static final String TAG = ImageStreamingUtil.class.getName();

    public static void loadImage(Context mContext,
                                 ImageView imageView,
                                 String imagePath) {

        StorageReference storageReference =
                FirebaseStorage.getInstance().getReference()
                        .child("garages");

        if (imagePath.equals("") ||
                (imagePath == null)) {
            imageView.setImageResource(R.drawable.ic_parking_spot_24);
        } else {
            int index = imagePath.lastIndexOf("/");
            String imageName = imagePath.substring(
                    index+1
            );
            GlideApp.with(mContext)
                    .load(storageReference.child(imageName))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    }




}

