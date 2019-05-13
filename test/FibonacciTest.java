import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FibonacciTest {


    private Fibonacci task;

    @Before
    public void init() {
        task = new Fibonacci();
    }

    @After
    public void deleteObject() {
        task = null;
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeFibonacci() {
        task.findFibonacciNumber(-5);
    }

    @Test(expected = InvalidParameterException.class)
    public void zeroFibonacci() {
        task.findFibonacciNumber(0);
    }

    @Test
    public void overMaxFibonacci() {
        assertEquals(-1, task.findFibonacciNumber(46));
        assertEquals(-1, task.findFibonacciNumber(99));
    }

    @Test
    public void findFibonacciNumber() {
        assertEquals(1, task.findFibonacciNumber(1));
        assertEquals(8, task.findFibonacciNumber(6));
        assertEquals(1134903170, task.findFibonacciNumber(45));
    }

}