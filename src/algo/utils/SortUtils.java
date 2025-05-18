package algo.utils;

import algo.Sorter;

import java.util.Comparator;
import java.util.Random;

public class SortUtils {

    public static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    // Проверка сортировки по natural order (Comparable)
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) return false;
        }
        return true;
    }

    // Проверка сортировки по кастомному компаратору
    public static <T> boolean isSorted(T[] array, Comparator<T> c) {
        for (int i = 1; i < array.length; i++) {
            if (c.compare(array[i - 1], array[i]) > 0) return false;
        }
        return true;
    }

    public static Integer[] generateRandomIntegerArray(int size, int bound) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(bound);
        return arr;
    }

    // Benchmark с natural order
    public static <T extends Comparable<T>> long benchmark(Sorter<T> sorter, T[] array) {
        T[] copy = array.clone();
        long start = System.nanoTime();
        sorter.sort(copy);
        long end = System.nanoTime();
        if (!isSorted(copy)) throw new RuntimeException("Sort failed!");
        return (end - start) / 1_000_000; // миллисекунды
    }

    // Benchmark с кастомным компаратором
    public static <T> long benchmark(Sorter<T> sorter, T[] array, Comparator<T> c) {
        T[] copy = array.clone();
        long start = System.nanoTime();
        sorter.sort(copy, c);
        long end = System.nanoTime();
        if (!isSorted(copy, c)) throw new RuntimeException("Sort failed!");
        return (end - start) / 1_000_000; // миллисекунды
    }
}
