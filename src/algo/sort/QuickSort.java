package algo.sort;

import algo.Sorter;

import java.util.Comparator;


public class QuickSort<T> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        sort(array, defaultComparator(array));
    }

    @Override
    public void sort(T[] array, Comparator<T> c) {
        quickSort(array, 0, array.length - 1, c);
    }

    private void quickSort(T[] array, int low, int high, Comparator<T> c) {
        if (low < high) {
            int pi = partition(array, low, high, c);
            quickSort(array, low, pi - 1, c);
            quickSort(array, pi + 1, high, c);
        }
    }

    private int partition(T[] array, int low, int high, Comparator<T> c) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (c.compare(array[j], pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    @SuppressWarnings("unchecked")
    private Comparator<T> defaultComparator(T[] array) {
        if (!(array[0] instanceof Comparable)) {
            throw new IllegalArgumentException("Elements must be Comparable");
        }
        return (o1, o2) -> ((Comparable<T>) o1).compareTo(o2);
    }
}
