package org.example.algorithms;

import org.example.metrics.Metrics;

public class HeapSort {
    private static void heapify(int[] arr, int n,int i, Metrics metrics) {
        metrics.enterRecursion();

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n ) {
            metrics.incrementArrayAccesses();
            metrics.incrementArrayAccesses();

            metrics.incrementComparisons();
            if (arr[l] > arr[largest]){
                largest = l;
            }
        }

        if (r < n) {
            metrics.incrementArrayAccesses();
            metrics.incrementArrayAccesses();

            metrics.incrementComparisons();
            if(arr[r] > arr[largest]){
                largest = r;
            }
        }

        if (largest != i) {
            metrics.incrementArrayAccesses(); //for reading arr[i]
            metrics.incrementArrayAccesses(); //for reading arr[largest]
            metrics.incrementArrayAccesses(); //for rewriting arr[i]
            metrics.incrementComparisons(); //for rewriting arr[largest]
            metrics.incrementSwaps();

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest,metrics);
        }

        metrics.exitRecursion();
    }

    public static void heapSort(int[] arr, Metrics metrics) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i,metrics);
        }

        for (int i = n - 1; i > 0; i--) {
            metrics.incrementArrayAccesses(); // for reading arr[0]
            metrics.incrementArrayAccesses(); // for reading arr[i]
            metrics.incrementArrayAccesses(); // for rewrriting arr[0]
            metrics.incrementArrayAccesses(); // for rewriting arr[i]
            metrics.incrementSwaps();

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0,metrics);
        }
    }
}
