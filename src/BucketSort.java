import java.util.*;

public class BucketSort implements Executable {
    private Scanner scan;

    public BucketSort(Scanner scan) {
        this.scan = scan;
    }

    @Override
    public void execute() {
        int[] setOfNumbers = inputValues();

        int count = setOfNumbers.length;
        System.out.println("Our set contains " + count + " numbers.");
        System.out.println(Arrays.toString(setOfNumbers));
        int maxNumber = findMaxNumber(setOfNumbers);
        System.out.println("Maximum number = " + maxNumber);
        int minNumber = findMinNumber(setOfNumbers);
        System.out.println("Minimum number = " + minNumber);

        int[] result = bucketSort(setOfNumbers);
        System.out.println(Arrays.toString(result));
    }

    private int[] inputValues() {
        System.out.println("Input a set of integer numbers: ");
        System.out.println("To finish entering numbers input any non-integer value.");
        List<Integer> setOfNumbers = new ArrayList<>();
        while (scan.hasNextInt()) {
            setOfNumbers.add(scan.nextInt());
        }
        int numbers[] = new int[setOfNumbers.size()];
        for (int i = 0; i < setOfNumbers.size(); i++) {
            numbers[i] = setOfNumbers.get(i);
        }
        return numbers;
    }

    private int findMaxNumber(int[] setOfNumbers) {
        int maxValue = 0;
        for (int i : setOfNumbers) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    private int findMinNumber(int[] setOfNumbers) {
        int minValue = Integer.MAX_VALUE;
        for (int i : setOfNumbers) {
            if (i < minValue) {
                minValue = i;
            }
        }
        return minValue;
    }

    private int msBits(int[] setOfNumbers, int number) {
        int maxNumber = findMaxNumber(setOfNumbers);
        int minNumber = findMinNumber(setOfNumbers);
        int count = setOfNumbers.length;
        return (int) (((double) (setOfNumbers[number] - minNumber) / (double) (maxNumber - minNumber + 1)) * count);
    }

    private int[] bucketSort(int[] setOfNumbers) {
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
