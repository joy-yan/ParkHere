package cs160.sjsu.edu.parkme.listener;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by joyyan on 11/5/17.
 */
public class TimePickerListener implements TimePickerDialog.OnTimeSetListener{

    private TextView textView;

    public TimePickerListener(TextView textView) {
        this.textView = textView;
    }

    private Calendar myCalendar = Calendar.getInstance();

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    private void updateLabel(TextView view) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        view.setText(sdf.format(myCalendar.getTime()));
    }


}
