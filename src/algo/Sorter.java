package algo;

import java.util.Comparator;

public interface Sorter<T> {
    void sort(T[] array);

    void sort(T[] array, Comparator<T> comparator);
}