import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class FibonacciTest {


    private Fibonacci task = new Fibonacci(new Scanner(System.in));

    @Test
    public void findFibonacciNumber() {
        assertEquals(-1, task.findFibonacciNumber(-8));
        assertEquals(-1, task.findFibonacciNumber(0));
        assertEquals(1, task.findFibonacciNumber(1));
        assertEquals(13, task.findFibonacciNumber(6));
    }

}