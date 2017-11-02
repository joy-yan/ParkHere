package cs160.sjsu.edu.parkme.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;

import cs160.sjsu.edu.parkme.R;

/**
 * Created by joyyan on 4/7/17.
 */

public class ImageStreamingUtil {

    private static final String TAG = ImageStreamingUtil.class.getName();

    public static void downloadFromFirebaseStorage(Context mContext,
                                                   StorageReference ref, ImageView imageView) {
//        Glide.with(mContext)
//                .using(new FirebaseImageLoader())
//                .load(ref)
//                .error(R.drawable.ic_parking_spot_24)
//                .placeholder(R.drawable.ic_parking_spot_24)     //设置占位图片
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .crossFade()
//                .into(imageView);
    }



}

