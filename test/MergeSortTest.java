import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

/**
 *
 */
public class MergeSortTest {

    /**
     * Validates {@link MergeSort#mergeSort(int[])} method.
     * Expected result: Arrays should be equal.
     */
    @Test
    public void mergeSortTest() {
        MergeSort mergeSort = new MergeSort();
        int[] actual = {2, 3, 5, 4, 6, 9, 8, 6};
        int[] expected = {2, 3, 4, 5, 6, 6, 8, 9};
        int[] result = mergeSort.mergeSort(actual);
        assertArrayEquals("Arrays should be equal", expected, result);
    }
}