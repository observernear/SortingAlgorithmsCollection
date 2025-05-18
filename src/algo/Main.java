package algo;

import algo.sort.*;
import algo.utils.SortUtils;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int size = 100_000;
        Integer[] array = SortUtils.generateRandomIntegerArray(size, 100);

        Sorter<Integer>[] sorters = new Sorter[] {
                new BubbleSort<>(),
                new SelectionSort<>(),
                new InsertionSort<>(),
                new HeapSort<>(),
                new QuickSort<>()
        };

        for (Sorter<Integer> sorter : sorters) {
            Integer[] copy = array.clone();

            // Для медленных сортировок ограничим размер
            if (size > 10_000 && (sorter instanceof BubbleSort || sorter instanceof SelectionSort || sorter instanceof InsertionSort)) {
                copy = java.util.Arrays.copyOf(copy, 10_000);
                System.out.printf("%s running on 10,000 elements%n", sorter.getClass().getSimpleName());
            }

            long timeMs = SortUtils.benchmark(sorter, copy);
            System.out.printf("%s took %d ms%n", sorter.getClass().getSimpleName(), timeMs);
        }

        // Пример с Comparator — по убыванию
        System.out.println("Custom Comparator (descending) with QuickSort:");
        Integer[] arrDesc = array.clone();
        new QuickSort<Integer>().sort(arrDesc, Comparator.reverseOrder());
        // Для большого массива печать неактуальна, можно ограничить вывод
        for (int i = 0; i < Math.min(20, arrDesc.length); i++) {
            System.out.print(arrDesc[i] + " ");
        }
        System.out.println();
    }
}

