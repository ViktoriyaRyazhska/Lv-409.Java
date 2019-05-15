import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {



    @Test
    public void insertionSortTest() {

        InsertionSort sort = new InsertionSort();
        int[] actual = {9, 8, 7, 6, 9, 6};
        int[] expected = {6, 6, 7, 8, 9, 9};
        sort.insertionSort(actual);
        assertArrayEquals(expected, actual);

    }

}
