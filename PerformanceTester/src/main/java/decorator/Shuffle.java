package decorator;

import performancetester.SortingAlgorithm;

import java.util.Random;

public class Shuffle extends Decorator {
    private SortingAlgorithm sortingAlgorithm;

    public Shuffle(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void sort(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int randomIndex = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        sortingAlgorithm.sort(array);
    }
}
