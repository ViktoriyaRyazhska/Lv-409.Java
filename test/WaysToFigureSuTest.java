import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class WaysToFigureSuTest {

    private WaysToFigureSum test = new WaysToFigureSum(new Scanner(System.in));

    @Test
    public void waysToSum() {
        assertEquals(1, test.waysToSum(2));
        assertEquals(2, test.waysToSum(3));
        assertEquals(4, test.waysToSum(4));
        assertEquals(6, test.waysToSum(5));
    }
}