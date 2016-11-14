package onlyme.sengupta.mon.loader;

import org.junit.Test;

import static onlyme.sengupta.mon.loader.MainActivity.mychecker;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void division_isCorrect() throws Exception {
        assertEquals(32, mychecker(16 , 2));
    }
}