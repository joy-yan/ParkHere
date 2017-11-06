package cs160.sjsu.edu.parkme.ui.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.utils.Utils;

/**
 * Created by joyyan on 11/2/17.
 */

public class OwnerFragment extends BaseFragment
        implements DatePickerDialog.OnDateSetListener {

    @BindView(R.id.edit_ads_start_date)
    EditText startDate;

    @BindView(R.id.edit_ads_end_date)
    EditText endDate;

    @BindView(R.id.edit_ads_start_hour)
    EditText startHour;

    @BindView(R.id.edit_ads_end_hour)
    EditText endHour;

    @BindView(R.id.edit_park_address)
    EditText garageAddress;

    @BindView(R.id.edit_parking_city)
    EditText garageCity;

    @BindView(R.id.edit_parking_ads_duration)
    EditText parkingDuration;

    @BindView(R.id.ibtn_take_photo)
    ImageButton ibtnTakePhoto;

    @BindView(R.id.edit_parking_description)
    EditText parkingDescription;

    @BindView(R.id.edit_parking_daily_rate)
    EditText parkingDailyRate;

    @OnClick(R.id.edit_ads_start_date)
    private void setStartDate() {

    }


    public static OwnerFragment newInstance() {
        OwnerFragment fragment = new OwnerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initVariables() {

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_owner, container, false);
        ButterKnife.bind(this, rootview);

        ibtnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto(ibtnTakePhoto);
            }
        });

        return rootview;
    }

    @Override
    protected void loadData() {

    }

    private void takePhoto(View view) {
        PickImageDialog.build(new PickSetup())
                .setOnPickResult(new IPickResult() {
                    @Override
                    public void onPickResult(PickResult pickResult) {
                        if (pickResult.getError() == null) {
                            ibtnTakePhoto.setImageBitmap(pickResult.getBitmap());
                        } else {
                            Toast.makeText(getActivity(),
                                    pickResult.getError().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                }).show(getActivity().getSupportFragmentManager());
    }


    @OnClick(R.id.ibtn_show_my_ads)
    public void showMyAds() {

    }

    @OnClick(R.id.btn_submit_new_ads)
    public void submitNewAds() {

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setAddress(garageAddress.getText().toString());
        parkingSpot.setCity(garageCity.getText().toString());
        parkingSpot.setDailyRate(parkingDailyRate.getText().toString());
        parkingSpot.setDescription(parkingDescription.getText().toString());
        parkingSpot.setDurantion(parkingDuration.getText().toString());
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }






}
