package cs160.sjsu.edu.parkme;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

import cs160.sjsu.edu.parkme.ui.login.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by srava on 11/8/17.
 * Sources:
 * https://github.com/vgrec/EspressoExamples/blob/master/app/src/androidTest/java/com/vgrec/espressoexamples/DateTimePickerTest.java
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class OwnerFragmentTest2 {
    private String sampleAddress, correctAddrFormat, incorrectAddrFormat, sampleCity;

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        sampleAddress = "1 Washington Sq, San Jose, CA 95192";
        sampleCity = "Cupertino";

    }

    // Testing city field to see if sample address inputted matches expected
    @Test
    public void testCity() {
        // Navigate to owner page
        onView(withId(R.id.navigation_owner))
                .perform(click());

        // Type sample text of city
        onView(withId(R.id.edit_parking_city))
                .perform(click())
                .perform(typeText(sampleCity));

        // Check if inputted text matches expected text
        onView(withId(R.id.edit_parking_city)).check(matches(withText(sampleCity)));
    }

    // Testing parking address field to see if sample address inputted matches expected
    @Test
    public void testParkingAddress() {
        // Navigate to owner page
        onView(withId(R.id.navigation_owner))
                .perform(click());

        // Type sample text of address
        onView(withId(R.id.edit_park_address))
                .perform(click())
                .perform(typeText(sampleAddress));

        // Check if inputted text matches expected text
        onView(withId(R.id.edit_park_address)).check(matches(withText(sampleAddress)));
    }

    // Testing start date from DatePicker to see if date inputted matches expected
    @Test
    public void testStartDate() {
        // Navigate to owner page
        onView(withId(R.id.navigation_owner))
                .perform(click());

        // Sample values for day, month, year
        int year = 2017;
        int month = 11;
        int day = 12;

        // Input sample values into DatePicker
        onView(withId(R.id.edit_ads_start_date)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(year, month, day));
        onView(withId(android.R.id.button1)).perform(click());

        // Check if input matches expected
        onView(withId(R.id.edit_ads_start_date))
                .check(matches(withText(month + "/" + day + "/17")));
    }

    // Testing end date from DatePicker to see if date inputted matches expected
    @Test
    public void testEndDate() {
        onView(withId(R.id.navigation_owner))
                .perform(click());

        // Sample values for day, month, year
        int year = 2017;
        int month = 11;
        int day = 13;

        // Input sample values into DatePicker
        onView(withId(R.id.edit_ads_end_date)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(year, month, day));
        onView(withId(android.R.id.button1)).perform(click());

        // Check if input matches expected
        onView(withId(R.id.edit_ads_end_date))
                .check(matches(withText(month + "/" + day + "/17")));

    }

    // Testing start time from TimePicker to see if time inputted matches expected
    @Test
    public void testStartTime() {
        // Navigate to owner page
        onView(withId(R.id.navigation_owner))
                .perform(click());

        // Sample values for hour, minutes
        int hour = 10;
        int minutes = 59;

        // Input sample values into TimePicker
        onView(withId(R.id.edit_ads_start_hour)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(hour, minutes));
        onView(withId(android.R.id.button1)).perform(click());

        // Check if input matches expected
        onView(withId(R.id.edit_ads_start_hour))
                .check(matches(withText(hour + ":" + minutes + ":00")));
    }

    // Testing end time from TimePicker to see if time inputted matches expected
    @Test
    public void testEndTime() {
        // Navigate to owner page
        onView(withId(R.id.navigation_owner))
                .perform(click());

        // Sample values for hour, minutes
        int hour = 14;
        int minutes = 59;

        // Input sample values into TimePicker
        onView(withId(R.id.edit_ads_end_hour)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(hour, minutes));
        onView(withId(android.R.id.button1)).perform(click());

        // Check if input matches expected
        onView(withId(R.id.edit_ads_end_hour))
                .check(matches(withText(hour + ":" + minutes + ":00")));
    }

    // Testing logout button to see if user successfully logs out
    @Test public void testLogout() {
        // Navigate to profile page
        onView(withId(R.id.navigation_profile))
                .perform(click());

        // Click on logout button
        onView(withId(R.id.fab_profile_logout))
                .perform(click());

        // Message should be displayed to indicate logout was successful
        onView(withText(R.string.msg_logout)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}
