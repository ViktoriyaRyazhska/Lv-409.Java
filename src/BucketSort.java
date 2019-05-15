import java.util.*;

/**
 * Class for sorting an array by using the "Bucket Sort" algorithm.
 *
 * @author Olha Lozinska
 */

public class BucketSort implements Executable {

    /**
     * Main method for getting input, calculating and output of result.
     */
    @Override
    public void execute() {
        int[] inputArray = input();
        int[] result = output(inputArray);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method for getting input from user: the array of numbers.
     *
     * @return int[] - the array of numbers.
     */
    private int[] input() {
        Scanner scan = new Scanner(System.in);
        int arrayLength;
        System.out.println("Enter number of elements in array:");

        while (true) {
            arrayLength = scan.nextInt();
            if (arrayLength > 0) {
                break;
            }
            System.out.println("The array length should be positive. Enter once more:");
        }

        int[] setOfNumbers = new int[arrayLength];
        System.out.println("Enter " + arrayLength + " integer elements of the array:");
        for (int i = 0; i < arrayLength; i++) {
            setOfNumbers[i] = scan.nextInt();
        }

        System.out.println(Arrays.toString(setOfNumbers));
        return setOfNumbers;
    }

    /**
     * Method for printing execution result.
     *
     * @param setOfNumbers the array of numbers.
     */
    private int[] output(int[] setOfNumbers) {
        return bucketSort(setOfNumbers);
    }

    /**
     * Method for searching the maximal number of array.
     *
     * @param setOfNumbers the array of numbers.
     */
    private int findMaxNumber(int[] setOfNumbers) {
        int maxValue = 0;
        for (int i : setOfNumbers) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    /**
     * Method for searching the minimal number of array.
     *
     * @param setOfNumbers The array of numbers.
     */
    private int findMinNumber(int[] setOfNumbers) {
        int minValue = Integer.MAX_VALUE;
        for (int i : setOfNumbers) {
            if (i < minValue) {
                minValue = i;
            }
        }
        return minValue;
    }

    /**
     * Method for calculating the number of bucket.
     *
     * @param setOfNumbers The array of numbers.
     * @param number       The position number of an element in array of numbers.
     * @return The number of bucket.
     */
    private int msBits(int[] setOfNumbers, int number) {
        int maxNumber = findMaxNumber(setOfNumbers);
        int minNumber = findMinNumber(setOfNumbers);
        int count = setOfNumbers.length;
        return (int) (((double) (setOfNumbers[number] - minNumber)
            / (double) (maxNumber - minNumber + 1)) * count);
    }

    /**
     * Method for sorting the array by using the "Bucket Sort" algorithm .
     *
     * @param setOfNumbers The array of numbers.
     * @return Sorted array of numbers.
     */
    public int[] bucketSort(int[] setOfNumbers) {
        Map<Integer, List<Integer>> sortedMap = new HashMap<>();
        for (int i = 0; i < setOfNumbers.length; i++) {
            int currentPosition = msBits(setOfNumbers, i);
            List<Integer> currentNumbers = sortedMap.get(currentPosition);
            if (Objects.nonNull(currentNumbers)) {
                currentNumbers.add(setOfNumbers[i]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(setOfNumbers[i]);
                sortedMap.put(currentPosition, list);
            }
        }

        int[] sortedNumbers = new int[setOfNumbers.length];
        int position = 0;
        for (List<Integer> list : sortedMap.values()) {
            if (list.size() == 1) {
                sortedNumbers[position] = list.get(0);
                position++;
            } else {
                Collections.sort(list);
                for (Integer number : list) {
                    sortedNumbers[position] = number;
                    position++;
                }
            }
        }
        return sortedNumbers;
    }
}
