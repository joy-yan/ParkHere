package cs160.sjsu.edu.parkme.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.ui.widgets.DatePickerFragment;
import cs160.sjsu.edu.parkme.ui.widgets.TimePickerFragment;

/**
 * Created by srava on 11/19/17.
 */

public class BookingFragment extends BaseFragment {

    @BindView(R.id.startDateEditText)
    EditText startDate;

    @BindView(R.id.endDateEditText)
    EditText endDate;

    @BindView(R.id.startTimeEditText)
    EditText startTime;

    @BindView(R.id.endTimeEditText)
    EditText endTime;

    @OnClick(R.id.startDateEditText)
    public void setStartDate() {
        DialogFragment newFragment = new DatePickerFragment(startDate);
        newFragment.show(getActivity().getSupportFragmentManager(), "DatePicker");
    }

    @OnClick(R.id.endDateEditText)
    public void setEndDate() {
        DialogFragment newFragment = new DatePickerFragment(endDate);
        newFragment.show(getActivity().getSupportFragmentManager(), "DatePicker");
    }

    @OnClick(R.id.startTimeEditText)
    public void setStartHour() {
        DialogFragment newFragment = new TimePickerFragment(startTime);
        newFragment.show(getActivity().getSupportFragmentManager(), "TimePicker");
    }

    @OnClick(R.id.endTimeEditText)
    public void setEndHour() {
        DialogFragment newFragment = new TimePickerFragment(endTime);
        newFragment.show(getActivity().getSupportFragmentManager(), "TimePicker");
    }

    public static BookingFragment newInstance() {
        BookingFragment fragment = new BookingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_booking, container, false);
        ButterKnife.bind(this, rootview);

        initialDateTimeInformation();
        return rootview;
    }

    private void initialDateTimeInformation() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

        String dateAsString = dateFormatter.format(new Date());
        String timeAsString = timeFormatter.format(new Date());

        startDate.setText(dateAsString);
        endDate.setText(dateAsString);
        startTime.setText(timeAsString);
        endTime.setText(timeAsString);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initVariables() {

    }
}