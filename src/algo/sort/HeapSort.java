package algo.sort;

import algo.Sorter;

import java.util.Comparator;


public class HeapSort<T> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        sort(array, defaultComparator(array));
    }

    @Override
    public void sort(T[] array, Comparator<T> c) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i, c);

        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, c);
        }
    }

    private void heapify(T[] array, int n, int i, Comparator<T> c) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;

        if (l < n && c.compare(array[l], array[largest]) > 0)
            largest = l;
        if (r < n && c.compare(array[r], array[largest]) > 0)
            largest = r;

        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest, c);
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
