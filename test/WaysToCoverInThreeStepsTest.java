import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class WaysToCoverInThreeStepsTest {

    @Test
    public void countWays() {
        WaysToCoverInThreeSteps ways = new WaysToCoverInThreeSteps();
        assertEquals(24, ways.countWays(6));
        assertEquals(1, ways.countWays(0));
        assertEquals(0, ways.countWays(-1));
    }
}