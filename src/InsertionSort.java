import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorting of int[] array by "Insertion Sort" algorithm.
 * 
 * @author Rostyslav Hlynka
 */

public class InsertionSort implements Executable {

    private Scanner sc;

    /**
     * Constuctor of InsertionSort's class.
     * 
     * @param sc input scanner
     */
    public InsertionSort(Scanner sc) {
        this.sc = sc;
    }

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
