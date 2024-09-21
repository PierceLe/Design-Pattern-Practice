package performancetester;

import decorator.ExecutionTime;
import decorator.Shuffle;

import java.util.Random;

public class PerformanceTest {
    public static int[] generateIntArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(); // Generates a random integer
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = generateIntArray(1000);

        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm quickSort = new QuickSort();

        // Measure the performance of quick sort on an unsorted list
        System.out.println("Quicksort an unsorted list");
        ExecutionTime quickSortExecuteTime = new ExecutionTime(quickSort);
        quickSortExecuteTime.sort(array);

        // Measure the performance of quick sort on a sorted list
        System.out.println("Quicksort a sorted list");
        quickSortExecuteTime.sort(array);
        // Measure the performance of bubble sort on an unsorted list
        System.out.println("Bubble sort an shuffled list");
        ExecutionTime bubbleSortExecuteTime = new ExecutionTime(bubbleSort);
        Shuffle shuffleArray = new Shuffle(bubbleSortExecuteTime);
        shuffleArray.sort(array);
        // Measure the performance of bubble sort on a sorted list
        System.out.println("Bubble sort a sorted list");
        bubbleSortExecuteTime.sort(array);
    }
}
