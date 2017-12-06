package cs160.sjsu.edu.parkme.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import butterknife.OnClick;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.BaseActivity;
import cs160.sjsu.edu.parkme.ui.fragments.BaseFragment;
import cs160.sjsu.edu.parkme.ui.fragments.BookingFragment;
import cs160.sjsu.edu.parkme.utils.ImageStreamingUtil;

/**
 * Created by joyyan on 11/2/17.
 */

public class DetailFragment extends BaseFragment {
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

    @BindView(R.id.btn_schedule)
    Button btnSchedule;

    private ParkingSpot parkingSpot;

    @OnClick(R.id.btn_schedule)
    public void startSchedule() {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BookingFragment bookingFragment = new BookingFragment();
        fragmentTransaction.replace(R.id.pay_fragment_container, bookingFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }


    @Override
    protected void initVariables() {

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootview);

        return rootview;
    }



    @Override
    protected void loadData() {
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            parkingSpot = Parcels.unwrap(extras.getParcelable("PARKING_SPOT_DETAIL"));
        }
        description.setText(parkingSpot.getDescription());
        ratingBar.setRating((float) parkingSpot.getRating());
        address.setText(parkingSpot.getAddress());
        city.setText(parkingSpot.getCity());
        price.setText("Price: $" + parkingSpot.getDailyRate() + "/day");
        ImageStreamingUtil.loadImage(getActivity(), parkingImg, parkingSpot.getPhotoUrl());
    }


}
