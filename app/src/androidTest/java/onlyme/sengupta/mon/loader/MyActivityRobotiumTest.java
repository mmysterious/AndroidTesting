package onlyme.sengupta.mon.loader;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by mondrita on 11/13/16.
 */
public class MyActivityRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public MyActivityRobotiumTest() {
        super(MainActivity.class);
    }
    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    public void testMyActivity() {
        solo.assertCurrentActivity("MyActivity", MainActivity.class);
    }
    public void testSayHello() {
        solo.enterText(0, "Dolly");
        solo.clickOnButton("submit");
        solo.assertCurrentActivity("WelcomeActivity", WelcomeActivity.class);
        solo.searchText("Hello Dolly");
    }
    public void tearDown() {
        solo.finishOpenedActivities();
    }
}
