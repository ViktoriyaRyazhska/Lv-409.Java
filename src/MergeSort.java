import java.util.Arrays;
import java.util.Scanner;

public class MergeSort implements Executable {
    private Scanner in;

    public MergeSort(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        int[] array;
        array = input();
        // output unsorted array
        System.out.println(Arrays.toString(array));
        // output sorted array
        System.out.println(Arrays.toString(mergeSort(array)));
    }

    private int[] input() {
        int arrayLength;
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
        int[] array;
        // allocate memory for array and input it
        array = new int[arrayLength];
        System.out.println("Enter " + arrayLength + " integer elements of the array:");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    public int[] mergeSort(int[] array) {
        int lengthOfArray = array.length;
        if (lengthOfArray < 2) {
            return array;
        }
        int middle = lengthOfArray / 2;
        // divide array into small arrays and than merge + sort them
        return merge(mergeSort(Arrays.copyOfRange(array, 0, middle)),
            mergeSort(Arrays.copyOfRange(array, middle, lengthOfArray)));
    }

    private int[] merge(int[] firstArray, int[] secondArray) {
        int lengthOfFirstArray = firstArray.length;
        int lengthOfSecondArray = secondArray.length;
        int indexOfFirstArray = 0;
        int indexOfSecondArray = 0;
        int fullLength = lengthOfFirstArray + lengthOfSecondArray;
        // array that will be merged from first and second arrays
        int[] resultArray = new int[fullLength];
        // merging first and second array into one sorted array
        for (int i = 0; i < fullLength; i++) {
            if (indexOfFirstArray < lengthOfFirstArray && indexOfSecondArray < lengthOfSecondArray) {
                if (firstArray[indexOfFirstArray] > secondArray[indexOfSecondArray]) {
                    resultArray[i] = secondArray[indexOfSecondArray];
                    indexOfSecondArray++;
                } else {
                    resultArray[i] = firstArray[indexOfFirstArray++];
                }
            } else if (indexOfSecondArray < lengthOfSecondArray) {
                resultArray[i] = secondArray[indexOfSecondArray++];
            } else {
                resultArray[i] = firstArray[indexOfFirstArray++];
            }
        }
        // return merged and sorted array
        return resultArray;
    }
}
