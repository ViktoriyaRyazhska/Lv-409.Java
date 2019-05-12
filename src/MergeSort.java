import java.util.Arrays;
import java.util.Scanner;

public class MergeSort implements Executable {
    private Scanner in;

    public MergeSort(Scanner in) {
        this.in = in;
    }

    @Override
    public void execute() {
        int[] array = input();
        output(array);
        output(mergeSort(array));
    }

    private void output(int[] array) {
        System.out.println(Arrays.toString(array));
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
        printPartsOfArray(array, middle, lengthOfArray);
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
