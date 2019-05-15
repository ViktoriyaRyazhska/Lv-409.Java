import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void quickSort() {
        QuickSort sort = new QuickSort();
        int[] actual = {9, 8, 7, 6, 9, 6};
        int[] expected = {6, 6, 7, 8, 9, 9};
        sort.quickSort(actual, 0, actual.length-1);
        assertArrayEquals(expected, actual);
    }
}
