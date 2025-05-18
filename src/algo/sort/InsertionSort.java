package algo.sort;

import algo.Sorter;

import java.util.Comparator;

public class InsertionSort<T> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        sort(array, defaultComparator(array));
    }

    @Override
    public void sort(T[] array, Comparator<T> c) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && c.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
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
