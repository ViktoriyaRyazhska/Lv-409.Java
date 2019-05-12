import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class PaintingFenceTest {

    PaintingFence test;

    @Before
    public void setUp() throws Exception {
        test = new PaintingFence(new Scanner(System.in));
    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void paintFence() {
        assertEquals(0, test.paintFence(0, 2));
        assertEquals(4, test.paintFence(1, 4));
        assertEquals(16, test.paintFence(2, 4));
        assertEquals(24, test.paintFence(3, 3));
    }
}