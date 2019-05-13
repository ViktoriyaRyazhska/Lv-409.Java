import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class CountingSortTest {

    @Test
    public void defaultArraySort(){
        CountingSort countingSort = new CountingSort();
        int[] actual = {9, 8, 7, 6, 9, 6};
        int[] expected = {6, 6, 7, 8, 9, 9};
        countingSort.countingSort(actual);
        assertArrayEquals(expected, actual);

        int[] zerosActual = {0, 0, 0, 0, 0, 0};
        int[] zerosExpected = {0, 0, 0, 0, 0, 0};
        countingSort.countingSort(zerosActual);
        assertArrayEquals(zerosExpected, zerosActual);


    }


}
