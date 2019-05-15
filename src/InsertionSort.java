import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorting of int[] array by "Insertion Sort" algorithm.
 * 
 * @author Rostyslav Hlynka
 */

public class InsertionSort implements Executable {

    /**
     * Runs the task's implementation.
     */
    @Override
    public void execute() {
        
        int[] array = initArray();
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Implementing "Insertion Sort" algorithm.
     * 
     * @param array array that need to be sorted
     */
    public void insertionSort(int[] array) {

        for (int i = 1; i < array.length; ++i) {

            int keyElement = array[i];
            int j = i - 1;

            /*
             * Move all elements of array, that are greater than keyElement to one position
             * ahead of their current position
             */
            while (j >= 0 && array[j] > keyElement) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = keyElement;
        }

    }

    /**
     * Initialize int[] array (by user input), that need to be sorted.
     * 
     * @return array that need to be sorted
     */
    private int[] initArray() {

        Scanner sc = new Scanner(System.in);

        int arrayLength;

        System.out.println("Enter number of elements in array:");

        while (true) {
            
            arrayLength = sc.nextInt();
            // if valid length of array - breaks from loop and continue execution
            if (arrayLength > 0) {
                break;
            }
            
            System.out.println("The array length should be positive. Enter once more:");
        }
        
        int[] array = new int[arrayLength];
        
        System.out.println("Enter " + arrayLength + " integer elements of the array:");
        
        for (int i = 0; i < arrayLength; i++) {
            array[i] = sc.nextInt();
        }

        return array;
        
    }

}
