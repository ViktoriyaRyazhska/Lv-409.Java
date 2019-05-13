import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class WaysToTileTest {

    private WaysToTile test;

    @Before
    public void setUp() throws Exception {
        test = new WaysToTile();
    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void countNumberOfWays() {
        assertEquals(1,test.countNumberOfWays(2,3));
        assertEquals(2,test.countNumberOfWays(4,4));
    }

    @Test (expected = InvalidParameterException.class)
    public void countNumberOfWaysException() {
        test.countNumberOfWays(-1,3);
        test.countNumberOfWays(1,-2);
        test.countNumberOfWays(-1, -1);
    }
}