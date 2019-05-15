import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BucketSortTest {
    BucketSort task;

    @Before
    public void init() {
        task = new BucketSort();
    }

    @After
    public void deleteObject() {
        task = null;
    }

    @Test
    public void bucketSort() {
        int[] actual = {9, 8, 7, 6, 9, 6};
        int[] expected = {6, 6, 7, 8, 9, 9};
        actual = task.bucketSort(actual);
        assertArrayEquals(expected, actual);
    }
}
