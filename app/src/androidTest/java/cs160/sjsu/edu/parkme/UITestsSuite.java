package cs160.sjsu.edu.parkme;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cs160.sjsu.edu.parkme.ui.MainActivity;
import cs160.sjsu.edu.parkme.ui.login.LoginActivity;

/**
 * Created by joyyan on 11/9/17.
 */
/**
 * Runs all instrumentation tests from one place
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntentsTest.class,
        LoginActivityTest.class,
        MainActivityTest.class,
})
public class UITestsSuite {

}
