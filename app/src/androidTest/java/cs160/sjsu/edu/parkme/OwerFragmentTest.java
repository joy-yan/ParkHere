package cs160.sjsu.edu.parkme;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

/**
 * Created by joyyan on 11/8/17.
 */



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import cs160.sjsu.edu.parkme.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class OwerFragmentTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Test public void testGoogleLogin() {
        onView(withId(R.id.button_google_login))
                .perform(click());
    }

    @Test public void testBottomNavigationView() {
        onView(withId(R.id.navigation_market))
                .perform(click());
        onView(withId(R.id.navigation_buyer))
                .perform(click());
        onView(withId(R.id.navigation_owner))
                .perform(click());
        onView(withId(R.id.navigation_profile))
                .perform(click());

    }

    @Test
    public void testParkingDescription() {
        onView(withId(R.id.navigation_owner))
                .perform(click());
        // Type text and then press the button.
        onView(withId(R.id.edit_parking_description))
                .perform(click())
                .perform(typeText(mStringToBetyped));
    }
}
