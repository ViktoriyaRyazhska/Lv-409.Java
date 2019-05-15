import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FriendPairsTest {

    FriendPairs task;

    @Before
    public void init() {
        task = new FriendPairs();
    }

    @After
    public void deleteObject() {
        task = null;
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeFindPairs() {
        task.findWaysOfPairing(-5);
    }

    @Test(expected = InvalidParameterException.class)
    public void zeroFindPairs() {
        task.findWaysOfPairing(0);
    }

    @Test
    public void overMaxFindPairs() {
        assertEquals(-1, task.findWaysOfPairing(18));
        assertEquals(-1, task.findWaysOfPairing(99));
    }

    @Test
    public void findPairs() {
        assertEquals(1, task.findWaysOfPairing(1));
        assertEquals(76, task.findWaysOfPairing(6));
        assertEquals(211799312, task.findWaysOfPairing(17));
    }

}