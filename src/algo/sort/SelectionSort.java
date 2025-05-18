package algo.sort;

import algo.Sorter;

import java.util.Comparator;

public class SelectionSort<T> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        sort(array, defaultComparator(array));
    }

    @Override
    public void sort(T[] array, Comparator<T> c) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (c.compare(array[j], array[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    private Comparator<T> defaultComparator(T[] array) {
        if (!(array[0] instanceof Comparable)) {
            throw new IllegalArgumentException("Elements must be Comparable");
        }
        return (o1, o2) -> ((Comparable<T>) o1).compareTo(o2);
    }
}