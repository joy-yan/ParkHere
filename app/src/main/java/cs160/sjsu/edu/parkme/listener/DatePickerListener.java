package cs160.sjsu.edu.parkme.listener;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by joyyan on 11/5/17.
 */

public class DatePickerListener implements DatePickerDialog.OnDateSetListener {

    private TextView textView;

    public DatePickerListener(TextView textView) {
        this.textView = textView;
    }

    private Calendar myCalendar = Calendar.getInstance();

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, month);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateLabel(textView);
    }

    private void updateLabel(TextView view) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        view.setText(sdf.format(myCalendar.getTime()));
    }
}
