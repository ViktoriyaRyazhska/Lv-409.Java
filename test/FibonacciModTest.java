import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class FibonacciModTest {

    private FibonacciMod findFibNumber = new FibonacciMod();
    /**
     * Validates {@link FibonacciMod#findFibNumber(int)} method.
     * Expected result: Elements should be equal.
     */
    @Test
    public void findFibNumberTest() {
        int actual = 6;
        int expected = 4;
        int result = findFibNumber.findFibNumber(actual);
        assertEquals("Elements should be equal", expected, result);
    }
}