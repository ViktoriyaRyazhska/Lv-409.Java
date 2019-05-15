import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for sorting int[] array using Counting Sort algorithm.
 *
 * @author Volodymyr Oseredchuk
 */
public class CountingSort implements Executable {

    /**
     * Method for executing algorithm - includes input and output.
     *
     * @throws InputMismatchException if input type is not compatible with int
     */
    @Override
    public void execute() throws InputMismatchException {
        int[] array = input();
        System.out.println(Arrays.toString(array)); // output unsorted array
        countingSort(array);
        System.out.println(Arrays.toString(array)); // output sorted array
    }

    /**
     * Method for getting int[] array from user.
     *
     * @return array int[] array that needs to be sorted
     * @throws InputMismatchException if input type is not compatible with int
     */
    public int[] input() throws InputMismatchException {
        int arrayLength;
        int[] array;
        Scanner in = new Scanner(System.in);
        // input array length
        System.out.println("Enter number of elements in array:");
        while (true) {
            arrayLength = in.nextInt();
            // if valid length of array - breaks from loop and continue execution
            if (arrayLength > 0) {
                break;
            }
            System.out.println("The array length should be positive. Enter once more:");
        }
        // allocate memory for array and input it
        array = new int[arrayLength];
        System.out.println("Enter " + arrayLength + " integer elements of the array:");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    /**
     * Method for Counting Sort algorithm.
     *
     * @param arr int[] array that needs to be sorted
     */
    public void countingSort(int[] arr) {
        if ((null == arr) || (arr.length < 2)) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        // search for min and max elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        /*
         * element corresponds to quantity of entries
         * (index of element + min) corresponds to value
         */
        int[] counts = new int[max - min + 1];
        // count quantity of each element entry in array
        for (int el : arr) {
            counts[el - min]++;
        }
        // fill array with sorted groups
        for (int i = 0, index = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                arr[index] = i + min;
                index++;
            }
        }
    }
}
