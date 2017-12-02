package cs160.sjsu.edu.parkme;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;


import cs160.sjsu.edu.parkme.ui.login.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    private String email;
    private String wrongPassword;
    private String correctPassword;
    private static final String BTN_SIGNIN_TEXT = "Sign In With Password";

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);



    @Before
    public void setWrongEmailPassword() {
        email = "tester@gmail.com";
        wrongPassword = "1234567890";
        correctPassword = "123456";
    }



    @Test
    public void testLoginWithWrongPassword() {
        onView(withId(R.id.edit_text_email)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.edit_text_password)).perform(typeText(wrongPassword),
                closeSoftKeyboard());
        onView(withId(R.id.login_with_password)).perform(click());
        onView(withText(R.string.auth_failed)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }


    @Test
    public void testLoginWithCorrectPassword() {
        onView(withId(R.id.edit_text_email)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.edit_text_password)).perform(typeText(correctPassword),
                closeSoftKeyboard());
        onView(withId(R.id.login_with_password))
                .check(matches(withText(BTN_SIGNIN_TEXT)));
        onView(withId(R.id.login_with_password)).perform(click());
    }


}