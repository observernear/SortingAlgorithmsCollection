package algo.sort;

import algo.Sorter;

import java.util.Comparator;

public class BubbleSort<T> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        sort(array, defaultComparator(array));
    }

    @Override
    public void sort(T[] array, Comparator<T> c) {
        int size = array.length;
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (c.compare(array[j], array[j + 1]) > 0) {  // data[j - 1] > data[j]
                    T tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Comparator<T> defaultComparator(T[] array) {
        if (array[0] == null) {
            throw new IllegalArgumentException("Elements must be Comparable");
        }
        return (o1, o2) -> ((Comparable<T>) o1).compareTo(o2);
    }
}
