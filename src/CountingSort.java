import java.util.Arrays;
import java.util.Scanner;

public class CountingSort implements Executable {
    private Scanner in;

    public CountingSort(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        int[] array = input();
        System.out.println(Arrays.toString(array)); // output unsorted array
        countingSort(array);
        System.out.println(Arrays.toString(array)); // output sorted array
    }

    private int[] input() {
        int arrayLength;
        int[] array;
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

    private void countingSort(int[] arr) {
        int min;
        int max;
        min = arr[0];
        max = arr[0];
        // search for min and max elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        // element corresponds to quantity of entries, (index of element + min) corresponds to value
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
