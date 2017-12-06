package cs160.sjsu.edu.parkme.ui.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.widgets.DatePickerFragment;
import cs160.sjsu.edu.parkme.ui.widgets.TimePickerFragment;
import cs160.sjsu.edu.parkme.utils.Utils;

/**
 * Created by joyyan on 11/2/17.
 */

public class OwnerFragment extends BaseFragment {


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

    @BindView(R.id.ibtn_take_photo)
    ImageButton ibtnTakePhoto;

    @BindView(R.id.edit_parking_description)
    EditText parkingDescription;

    @BindView(R.id.edit_parking_daily_rate)
    EditText parkingDailyRate;

    @OnClick(R.id.edit_ads_start_date)
    public void setStartDate() {
        DialogFragment newFragment = new DatePickerFragment(startDate);
        newFragment.show(getActivity().getSupportFragmentManager(), "DatePicker");
    }


    @OnClick(R.id.edit_ads_end_date)
    public void setEndDate() {
        DialogFragment newFragment = new DatePickerFragment(endDate);
        newFragment.show(getActivity().getSupportFragmentManager(), "DatePicker");
    }

    @OnClick(R.id.edit_ads_start_hour)
    public void setStartHour() {
        DialogFragment newFragment = new TimePickerFragment(startHour);
        newFragment.show(getActivity().getSupportFragmentManager(), "TimePicker");
    }


    @OnClick(R.id.edit_ads_end_hour)
    public void setEndHour() {
        DialogFragment newFragment = new TimePickerFragment(endHour);
        newFragment.show(getActivity().getSupportFragmentManager(), "TimePicker");
    }

    public static OwnerFragment newInstance() {
        OwnerFragment fragment = new OwnerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initVariables() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        parkingSpot = new ParkingSpot();
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
        initialDateTimeInformation();
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
                             parkingSpot.setPhotoUrl(pickResult.getPath());
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

        parkingSpot.setAddress(garageAddress.getText().toString());
        parkingSpot.setCity(garageCity.getText().toString());
        parkingSpot.setDailyRate(parkingDailyRate.getText().toString());
        parkingSpot.setDescription(parkingDescription.getText().toString());
        parkingSpot.setStartDate(startDate.getText().toString());
        parkingSpot.setEndDate(endDate.getText().toString());
        parkingSpot.setStartTime(startHour.getText().toString());
        parkingSpot.setEndTime(endHour.getText().toString());

        writeNewAd();

    }


    private void initialDateTimeInformation() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

        String dateAsString = dateFormatter.format(new Date());
        String timeAsString = timeFormatter.format(new Date());

        startDate.setText(dateAsString);
        endDate.setText(dateAsString);
        startHour.setText(timeAsString);
        endHour.setText(timeAsString);
    }

    private void writeNewAd() {
        FirebaseUser fbUser = FirebaseAuth.getInstance().getCurrentUser();
        if (fbUser != null) {
            String uid = fbUser.getUid();
            parkingSpot.setUid(uid);
            DatabaseReference marketRef = mDatabase.child("market").push();
            marketRef.setValue(parkingSpot);
            String key = marketRef.getKey();

            mDatabase.child("users").child(uid).child("ads").push().setValue(key);
            uploadImage();
            Utils.showToast(getActivity(), getString(R.string.firebase_new_ads_success));
        }
    }

    private void uploadImage() {
        if (parkingSpot.getPhotoUrl().length() > 1) {
            Uri file = Uri.fromFile(new File(parkingSpot.getPhotoUrl()));
            StorageReference photosRef = FirebaseStorage.getInstance().getReference()
                    .child("garages/"+file.getLastPathSegment());

            UploadTask uploadTask = photosRef.putFile(file);

            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Utils.showToast(getActivity(), getString(R.string.firebase_image_upload_failure));
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Utils.showToast(getActivity(), getString(R.string.firebase_image_upload_success));
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                }
            });
        }

    }

    private DatabaseReference mDatabase;
    private ParkingSpot parkingSpot;
}
