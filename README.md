# Sorting Algorithms Collection
[![Java](https://img.shields.io/badge/language-Java-red)](https://www.oracle.com/java/)

---

## О проекте

Этот репозиторий содержит реализацию популярных алгоритмов сортировки на языке Java с использованием универсальных дженериков и поддержки кастомных компараторов.

Проект ориентирован на образовательные цели и демонстрирует различные подходы к сортировке, а также позволяет проводить бенчмарки производительности.

---
## Реализованные алгоритмы

---

### 1. Bubble Sort (Сортировка пузырьком)

**Принцип работы:**  
Алгоритм многократно проходит по массиву, сравнивая соседние элементы и меняя их местами, если они находятся в неправильном порядке. Каждый проход "всплывает" максимальный элемент к концу массива.

![Bubble Sort](assets/BubbleVisual.gif)

**Код реализации:**  
[**Java**](src/algo/sort/BubbleSort.java)

---

### 2. Heap Sort (Пирамидальная сортировка)

**Принцип работы:**  
Алгоритм строит из массива структуру данных "кучу" (heap), после чего извлекает максимальный элемент из кучи и помещает его в конец массива, уменьшая размер кучи и повторяя процесс.

[Visualization on YouTube](https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.youtube.com/watch%3Fv%3DMtQL_ll5KhQ&ved=2ahUKEwjyw9bj5a2NAxWb_7sIHXX5JaEQtwJ6BAgiEAI&usg=AOvVaw1_g9BNFg7oksrXJoPg9CxT)

**Код реализации:**  
[**Java**](src/algo/sort/HeapSort.java)

---

### 3. Insertion Sort (Сортировка вставками)

**Принцип работы:**  
Алгоритм проходит по массиву, вставляя каждый следующий элемент в правильную позицию среди уже отсортированных элементов слева.

![Insertion Sort](assets/InsertionVisual.gif)

**Код реализации:**  
[**Java**](src/algo/sort/InsertionSort.java)

---

### 4. Quick Sort (Быстрая сортировка)

**Принцип работы:**  
Алгоритм "разделяй и властвуй": выбирается опорный элемент, массив делится на части с элементами меньше и больше опорного, затем рекурсивно сортируются части.

![Quick Sort](assets/QuickVisual.gif)

**Код реализации:**  
[**Java**](src/algo/sort/QuickSort.java)

---

### 5. Radix Sort (Поразрядная сортировка)

**Принцип работы:**  
Алгоритм сортирует числа поразрядно, начиная с младших разрядов и двигаясь к старшим, используя вспомогательную стабильную сортировку (обычно Counting Sort).

[Visualization on YouTube](https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.youtube.com/watch%3Fv%3Dnu4gDuFabIM&ved=2ahUKEwjKs4iv5a2NAxX1iP0HHRzJBooQwqsBegQIBRAG&usg=AOvVaw3YTJhLlw4nNEgg9JhpFpFc)

**Код реализации:**  
[**Java**](src/algo/sort/RadixSort.java)

---

### 6. Selection Sort (Сортировка выбором)

**Принцип работы:**  
Алгоритм на каждом шаге находит минимальный элемент из неотсортированной части массива и меняет его местами с первым элементом этой части.

![Selection Sort](assets/SelectionVisual.gif)

**Код реализации:**  
[**Java**](src/algo/sort/SelectionSort.java)

---

## Таблица
| Алгоритм        | Краткое описание                     | Временная сложность          | Пространственная сложность |
|-----------------|------------------------------------|-----------------------------|---------------------------|
| Bubble Sort     | Простая сортировка обменом          | O(n²)                       | O(1)                      |
| Selection Sort  | Выбор минимального элемента         | O(n²)                       | O(1)                      |
| Insertion Sort  | Вставка элементов в отсортированную часть | O(n²), O(n) для почти отсортированных | O(1)                      |
| Heap Sort       | Сортировка кучей                   | O(n log n)                  | O(1)                      |
| Quick Sort      | Быстрая сортировка методом "разделяй и властвуй" | O(n log n) среднее, O(n²) худший | O(log n)                  |
| Radix Sort      | Поразрядная сортировка для чисел   | O(d * (n + k)), где d — количество разрядов | O(n + k)                  |
---
## Benchmarking

Для оценки производительности реализован модуль [`Benchmark.java`](src/algo/Benchmark.java), который замеряет время выполнения каждого алгоритма на случайно сгенерированных данных.

### 📊 Пример результатов (массивы из 10 000, 100 000 случайных элементов, время в мс):

| Алгоритм        | 10K | 100K  |
|-----------------|-----|-------|
| Bubble Sort     | 151 | 27005 |   
| Selection Sort  | 65  | 5871  |
| Insertion Sort  | 79  | 8702  |
| Heap Sort       | 3   | 32    |
| Quick Sort      | 2   | 46    |
| Radix Sort      | -   | -     |

> \*Результаты приблизительные, могут меняться в зависимости от конфигурации ПК и JVM.
---
## Как использовать

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/observernear/SortingAlgorithmsCollection.git -o SortingAlgorithmsCollection
    cd SortingAlgorithmsCollection 
    ```

2. Соберите проект с помощью вашей любимой IDE (IntelliJ IDEA, Eclipse) или через командную строку:
    ```bash
    javac -d out src/algo/**/*.java
    java -cp out algo.Main
    ```

3. В [`Main.java`](src/algo/Main.java) и [`Benchmark.java`](src/algo/Benchmark.java) можно настроить:
    - Размер генерируемого массива
    - Выбор алгоритмов для запуска
    - Использование кастомных компараторов
