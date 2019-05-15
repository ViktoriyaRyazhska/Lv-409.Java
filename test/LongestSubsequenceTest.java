import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubsequenceTest {

    LongestSubsequence task;

    @Before
    public void init() {
        task = new LongestSubsequence();
    }

    @After
    public void deleteObject() {
        task = null;
    }

    @Test
    public void findLongestSubsequence() {
        assertEquals(-1, task.output(null));
        int[] arr = {3, 4, 7, 8, 9};
        assertEquals(3, task.output(arr));
        arr = new int[] {-5, -4, 0, 0, 1, 2, 4, 5, 6, 7};
        assertEquals(4, task.output(arr));
    }
}
