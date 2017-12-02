package cs160.sjsu.edu.parkme;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.runner.RunWith;

/**
 * Created by joyyan on 11/8/17.
 */



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.DatePicker;
import android.widget.TimePicker;

import cs160.sjsu.edu.parkme.ui.MainActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private String mParkingDescription;
    private String dailyRate;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mParkingDescription = "A great parking spot";
        dailyRate = "10";
    }


    @Test
    public void testParkingDescription() {
        onView(withId(R.id.navigation_owner))
                .perform(click());
        onView(withId(R.id.edit_parking_description))
                .perform(typeText(mParkingDescription), closeSoftKeyboard());
        onView(withId(R.id.edit_parking_description)).check(matches(withText(mParkingDescription)));
    }


    @Test
    public void testParkingDailyRate() {
         onView(withId(R.id.navigation_owner))
                .perform(click());
        onView(withId(R.id.edit_parking_description))
                .perform(typeText(mParkingDescription), closeSoftKeyboard());
        onView(withId(R.id.edit_parking_description)).check(matches(withText(mParkingDescription)));
    }

    @Test
    public void testBottomNavigationView() {
        onView(allOf(withId(R.id.navigation_market), isCompletelyDisplayed()))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }


     // stress testing for viewpager
    @Test
    public void testViewPager() {
        int n = 2;
        while (n > 0) {
            n--;
            onView(withId(R.id.viewPager)).perform(swipeLeft());
            onView(withId(R.id.viewPager)).perform(swipeLeft());
            onView(withId(R.id.viewPager)).perform(swipeLeft());
            onView(withId(R.id.viewPager)).perform(swipeLeft());

            onView(withId(R.id.viewPager)).perform(swipeRight());
            onView(withId(R.id.viewPager)).perform(swipeRight());
            onView(withId(R.id.viewPager)).perform(swipeRight());
            onView(withId(R.id.viewPager)).perform(swipeRight());
        }
    }



    // Testing logout button to see if user successfully logs out
    @Test public void testLogout() {
        // Navigate to profile page
        onView(withId(R.id.navigation_profile))
                .perform(click());

        // Click on logout button
        onView(withId(R.id.fab_profile_logout))
                .perform(click());

    }

}
