import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class FriendPairsTest {

    FriendPairs task = new FriendPairs(new Scanner(System.in));

    @Test
    public void findWaysOfPairing() {
        assertEquals(0, task.findWaysOfPairing(-8));
        assertEquals(0, task.findWaysOfPairing(0));
        assertEquals(0, task.findWaysOfPairing(1));
        assertEquals(4, task.findWaysOfPairing(3));
    }
}