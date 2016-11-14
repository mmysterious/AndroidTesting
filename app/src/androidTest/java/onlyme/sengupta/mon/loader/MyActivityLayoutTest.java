package onlyme.sengupta.mon.loader;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by mondrita on 11/13/16.
 */

@MediumTest
@RunWith(AndroidJUnit4.class)
public class MyActivityLayoutTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private TextView textView;
    private EditText editText;
    private Button helloButton;

    public MyActivityLayoutTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
        textView = (TextView) activity.findViewById(R.id.txtview);
        editText = (EditText) activity.findViewById(R.id.edittxt);
        helloButton = (Button) activity.findViewById(R.id.btn);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testPreconditions() {
        assertNotNull("Activity is null", activity);
        assertNotNull("TextView is null", textView);
        assertNotNull("EditText is null", editText);
        assertNotNull("HelloButton is null", helloButton);
    }
    @Test
    public void textView_label() {
        final String expected = "Hello World!";
        final String actual = textView.getText().toString();
        assertEquals(expected, actual);
    }
    @Test
    public void editText_hint() {
        final String expected = "checking";
        final String actual = editText.getText().toString();
        assertEquals(expected, actual);
    }
    @Test
    public void helloButton_label() {
        final String expected = "submit";
        final String actual = helloButton.getText().toString();
        assertEquals(expected, actual);
    }

}
