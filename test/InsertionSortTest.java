import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    /**
     * Test sorting algorithm.
     * First create mock input Stream.
     * Then use it to create Scanner and, therefore - Sorting object
     */

    @Test
    public void insertionSortTest() {
        String input = "9 8 7 6 9 6";
        ByteArrayInputStream bainput = new ByteArrayInputStream(input.getBytes());
        System.setIn(bainput);
        Scanner scanner = new Scanner(bainput);
        InsertionSort sort = new InsertionSort(scanner);
        int[] userArray = sort.initArray();
        sort.insertionSort(userArray);
        assertEquals("[6, 6, 7, 8, 9, 9]", Arrays.toString(userArray));

    }

}