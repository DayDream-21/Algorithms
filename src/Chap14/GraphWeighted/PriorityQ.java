package Chap14.GraphWeighted;

public class PriorityQ {
    // Массив отсортирован по убыванию от ячейки 0 до size-1
    private final int SIZE = 20;
    private Edge[] queArray;
    private int size;

    public PriorityQ() // Конструктор
    {
        queArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) { // Вставка элемента в порядке сортировки
        int j;
        for (j = 0; j < size; j++) { // Поиск места для вставки
            if (item.distance >= queArray[j].distance) {
                break;
            }
        }

        for (int k = size - 1; k >= j; k--) { // Перемещение элементов вверх
            queArray[k + 1] = queArray[k];
        }
        queArray[j] = item; // Вставка элемента
        size++;
    }

    public Edge removeMin() { // Извлечение наименьшего элемента
        return queArray[--size];
    }

    public void removeN(int n) { // Удаление элемента в позиции N
        for (int j = n; j < size - 1; j++) { // Перемещение элементов вниз
            queArray[j] = queArray[j + 1];
        }
        size--;
    }

    public Edge peekMin() { // Чтение наименьшего элемента

        return queArray[size - 1];
    }

    public int size() { // Получение количества элементов

        return size;
    }

    public boolean isEmpty() { // true, если очередь пуста

        return (size == 0);
    }

    public Edge peekN(int n) { // Чтение элемента в позиции N

        return queArray[n];
    }

    public int find(int findDex) { // Поиск элемента с заданным значением destVert
        for (int j = 0; j < size; j++) {
            if (queArray[j].destVert == findDex) {
                return j;
            }
        }
        return -1;
    }
}