package algorithms;

import org.example.algorithms.HeapSort;
import org.example.csvWriter.CSVWriter;
import org.example.metrics.Metrics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    private static void runTests(int[] arr) {
        Metrics metrics = new Metrics();
        int[] copy = Arrays.copyOf(arr, arr.length);

        HeapSort.heapSort(arr, metrics);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr, "Failed at: " + Arrays.toString(arr));
    }

    @Test
    void randomArray(){
        Random rand =new Random();

        for (int size = 1; size <= 100; size++) {
            int[] arr = rand.ints(size, -1000, 1000).toArray();
            runTests(arr);
        }
    }

    @Test
    void emptyArr(){
        runTests(new int[]{});
    }

    @Test
    void duplicatesArr(){
        runTests(new int[]{5, 1, 3, 5, 2, 1, 5});
    }

    @Test
    void singleElementArr(){
        runTests(new int[]{5});
    }

    @Test
    void sortedArr(){
        runTests(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void reversedArr(){
        runTests(new int[]{6, 5, 4, 3, 2, 1});
    }

    @Test
    void sameValueArr(){
        runTests(new int[]{1, 1,1,1,1,1,1,1,1,1,1,1,1,1,});
    }

    @Test
    void testScalability() {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random(123);

        for (int n : sizes) {
            int[] arr = random.ints(n, -1_000_000, 1_000_000).toArray();
            int[] copy= Arrays.copyOf(arr, arr.length);
            Metrics metrics = new Metrics();

            long start = System.nanoTime();
            Arrays.sort(copy);
            HeapSort.heapSort(arr, metrics);
            long end = System.nanoTime();

            assertArrayEquals(copy, arr, "Failed at: " + Arrays.toString(arr));

            System.out.printf("n=%d, time=%.3f ms, comparisons=%d, swaps=%d, accesses=%d, depth=%d\n",
                    n, (end - start) / 1e6, metrics.getComparisons(), metrics.getSwaps(),
                    metrics.getArrayAccesses(), metrics.getRecursionDepth());
        }
    }


}
