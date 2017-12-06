package cs160.sjsu.edu.parkme;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cs160.sjsu.edu.parkme.ui.login.CreateAccountActivity;
import cs160.sjsu.edu.parkme.ui.login.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by joyyan on 11/9/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class IntentsTest {

    @Rule
    public IntentsTestRule<LoginActivity> intentsTestRule =
            new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void testCreateAccountIntent() {
        onView(withId(R.id.tv_sign_up)).check(matches(withText("Create Account")));
        onView(withId(R.id.tv_sign_up)).perform(click());
        intended(hasComponent(CreateAccountActivity.class.getName()));
    }
}
