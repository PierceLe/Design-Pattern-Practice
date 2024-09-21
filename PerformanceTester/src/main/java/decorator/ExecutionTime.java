package decorator;

import performancetester.SortingAlgorithm;

import java.time.Duration;
import java.time.Instant;

public class ExecutionTime extends Decorator{
    private SortingAlgorithm sortingAlgorithm;
    public ExecutionTime(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void sort(int[] array) {
        Instant start = Instant.now();
        sortingAlgorithm.sort(array);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Execution time: " + timeElapsed.toNanos() + " nanoseconds");
    }
}
