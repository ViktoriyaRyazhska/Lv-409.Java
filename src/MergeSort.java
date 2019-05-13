import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for sorting array using "Merge Sort" algorithm.
 *
 * @author Danylo Lototskyi
 */
public class MergeSort implements Executable {

    /**
     * Main method for getting input and output.
     *
     * @throws InputMismatchException if user enter not integer value in input().
     */
    @Override
    public void execute() throws InputMismatchException {
        int[] arrayForSorting = input();
        System.out.println(Arrays.toString(arrayForSorting));
        System.out.println(Arrays.toString(mergeSort(arrayForSorting)));
    }

    /**
     * Method for getting input of number of elements in array and this array.
     *
     * @return integer array that will be sorted.
     * @throws InputMismatchException if user enters not integer value.
     */
    private int[] input() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int arrayLength;
        // input array length
        System.out.println("Enter number of elements in array:");
        while (true) {
            arrayLength = scanner.nextInt();
            // if valid length of array - breaks from loop and continue execution
            if (arrayLength > 0) {
                break;
            }
            System.out.println("The array length should be positive. Enter once more:");
        }
        int[] arrayForSorting;
        arrayForSorting = new int[arrayLength];
        System.out.println("Enter " + arrayLength + " integer elements of the array:");
        for (int i = 0; i < arrayLength; i++) {
            arrayForSorting[i] = scanner.nextInt();
        }
        scanner.close();
        return arrayForSorting;
    }

    /**
     * Method for sorting an array.
     *
     * @param arrayForSorting array that will be sorted.
     * @return sorted array.
     */
    public int[] mergeSort(int[] arrayForSorting) {
        int lengthOfArray = arrayForSorting.length;
        if (lengthOfArray < 2) {
            return arrayForSorting;
        }
        int middle = lengthOfArray / 2;
        printPartsOfArray(arrayForSorting, middle, lengthOfArray);
        // divide array into small arrays and than merge + sort them
        return merge(mergeSort(Arrays.copyOfRange(arrayForSorting, 0, middle)),
            mergeSort(Arrays.copyOfRange(arrayForSorting, middle, lengthOfArray)));
    }

    /**
     * Method for merging two arrays into one sorted array.
     *
     * @param leftArray  left part of array.
     * @param rightArray right part of array.
     * @return sorted array.
     */
    private int[] merge(int[] leftArray, int[] rightArray) {
        int lengthOfLeftArray = leftArray.length;
        int lengthOfRightArray = rightArray.length;
        int indexOfLeftArray = 0;
        int indexOfRightArray = 0;
        int fullLength = lengthOfLeftArray + lengthOfRightArray;
        // array that will be merged from first and second arrays
        int[] resultArray = new int[fullLength];
        // merging first and second array into one sorted array
        for (int i = 0; i < fullLength; i++) {
            if ((indexOfLeftArray < lengthOfLeftArray)
                && (indexOfRightArray < lengthOfRightArray)) {
                if (leftArray[indexOfLeftArray] > rightArray[indexOfRightArray]) {
                    resultArray[i] = rightArray[indexOfRightArray];
                    indexOfRightArray++;
                } else {
                    resultArray[i] = leftArray[indexOfLeftArray++];
                }
            } else if (indexOfRightArray < lengthOfRightArray) {
                resultArray[i] = rightArray[indexOfRightArray++];
            } else {
                resultArray[i] = leftArray[indexOfLeftArray++];
            }
        }
        // return merged and sorted array
        return resultArray;
    }

    /**
     * Method for printing left and right parts of array.
     *
     * @param array         array for printing.
     * @param middle        middle index of array.
     * @param lengthOfArray length of current array.
     */
    private void printPartsOfArray(int[] array, int middle, int lengthOfArray) {
        System.out.print("Left:[");
        for (int i = 0; i < middle; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\b] Right:[");
        for (int i = middle; i < lengthOfArray; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\b]");
    }
}
