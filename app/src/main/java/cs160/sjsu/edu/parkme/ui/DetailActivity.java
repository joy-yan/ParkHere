package cs160.sjsu.edu.parkme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.BaseActivity;
import cs160.sjsu.edu.parkme.utils.ImageStreamingUtil;

/**
 * Created by joyyan on 11/2/17.
 */

public class DetailActivity extends BaseActivity {
    @BindView(R.id.btn_submit_review)
    Button btnReveiw;

    @BindView(R.id.detailAddress)
    TextView address;

    @BindView(R.id.detailDesc)
    TextView description;

    @BindView(R.id.detailImg)
    ImageView parkingImg;

    @BindView(R.id.ratingStar)
    RatingBar ratingBar;

    @BindView(R.id.edit_review)
    EditText editReview;

    @BindView(R.id.detailPrice)
    TextView price;

    @BindView(R.id.parkingCity)
    TextView city;

    private ParkingSpot parkingSpot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void loadData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            parkingSpot = Parcels.unwrap(extras.getParcelable("PARKING_SPOT_DETAIL"));
        }
        description.setText(parkingSpot.getDescription());
        ratingBar.setRating((float) parkingSpot.getRating());
        address.setText(parkingSpot.getAddress());
        city.setText(parkingSpot.getCity());
        price.setText("Price: $" + parkingSpot.getDailyRate() + "/day");
        ImageStreamingUtil.loadImage(this, parkingImg, parkingSpot.getPhotoUrl());
    }


}
