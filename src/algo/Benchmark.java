package algo;

import algo.sort.*;

import java.util.Random;

public class Benchmark {

    private static final int[] SIZES = {10_000, 100_000}; // например, для теста больших размеров раскомментируй 1_000_000
    private static final int MAX_VALUE = 1_000_000;

    public static void main(String[] args) {

        Sorter<Integer> bubbleSort = new BubbleSort<>();
        Sorter<Integer> selectionSort = new SelectionSort<>();
        Sorter<Integer> insertionSort = new InsertionSort<>();
        Sorter<Integer> heapSort = new HeapSort<>();
        Sorter<Integer> quickSort = new QuickSort<>();

        for (int size : SIZES) {
            System.out.println("Размер массива: " + size);
            System.out.printf("%-15s | %-12s\n", "Алгоритм", "Время (мс)");
            System.out.println("-----------------|--------------");

            benchmark("Bubble Sort", bubbleSort, size);
            benchmark("Selection Sort", selectionSort, size);
            benchmark("Insertion Sort", insertionSort, size);
            benchmark("Heap Sort", heapSort, size);
            benchmark("Quick Sort", quickSort, size);
            System.out.println();
        }
    }

    private static void benchmark(String name, Sorter<Integer> sorter, int size) {
        Integer[] original = generateRandomArray(size);
        Integer[] data = original.clone();

        long start = System.nanoTime();
        sorter.sort(data);
        long end = System.nanoTime();

        long durationMs = (end - start) / 1_000_000;
        System.out.printf("%-15s | %-12d\n", name, durationMs);
    }

    private static Integer[] generateRandomArray(int size) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(MAX_VALUE);
        }
        return arr;
    }
}
