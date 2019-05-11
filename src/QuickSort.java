import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorting of int[] array by "Quick Sort" algorithm.
 * 
 * @author Rostyslav Hlynka
 */

public class QuickSort implements Executable {

    private Scanner sc;

    /**
     * Constuctor for QuickSort's class.
     * 
     * @param sc input scanner
     */
    public QuickSort(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Runs the task's implementation.
     */
    @Override
    public void execute() {
        int[] array = initArray();
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * Implementing "Quick Sort" algorithm.
     * 
     * @param array array that need to be sorted
     * @param start starting index
     * @param end   ending index
     */
    public void quickSort(int[] array, int start, int end) {

        if (start < end) {

            // p - index of pivot element at right position
            int pivotIndex = getPivot(array, start, end);

            // recursively sort elements before and after pivot element
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    /**
     * Takes last element as pivot and sorts: smaller elements than pivot to left of
     * pivot greater elements than pivot to right of pivot.
     * 
     * @param array array that need to be sorted
     * @param start starting index
     * @param end   ending index
     * @return index of pivot element at right position
     */
    private int getPivot(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
        }
        array[end] = array[i];
        array[i] = pivot;

        return i;
    }

    /**
     * Initialize int[] array (by user input), that need to be sorted.
     * 
     * @return array that need to be sorted
     */
    private int[] initArray() {

        System.out.println("Input array of integers, int[] ( e.g.: 3 2 1 4 0 ):");

        String inputtedLine = sc.nextLine();
        String[] inputtedWords = inputtedLine.split(" ");

        int[] array = new int[inputtedWords.length];

        try {

            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(inputtedWords[i]);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Try again. ");
            array = initArray();
        }

        return array;
    }

}
