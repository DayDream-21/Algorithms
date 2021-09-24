package data_structure_and_algorithms.Chap11.DoubleHashTable;

public class DoubleHashTable {
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem; // Для удаленных элементов

    
    public DoubleHashTable(int size) // Конструктор
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println();
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }
    
    public int hashFunc2(int key) {
    // Возвращаемое значение отлично от нуля, меньше размера массива,
    // функция отлична от хеш-функции 1
    // Размер массива должен быть простым по отношению к 5, 4, 3 и 2
        return 5 - key % 5;
    }
    
    // Вставка элемента данных
    public void insert(int key, DataItem item)
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc1(key); // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        // Пока не будет найдена
        while (hashArray[hashVal] != null && // пустая ячейка или -1
                hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize; // Прибавление смещения
            hashVal %= arraySize; // Возврат к началу
        }
        hashArray[hashVal] = item; // Вставка элемента
    }

    public DataItem delete(int key) // Удаление элемента данных
    {
        int hashVal = hashFunc1(key); // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        while (hashArray[hashVal] != null) // Пока не найдена пустая ячейка
        { // Ключ найден?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem; // Удаление элемента
                return temp; // Метод возвращает элемент
            }
            hashVal += stepSize; // Прибавление смещения
            hashVal %= arraySize; // Возврат к началу
        }
        return null; // Элемент не найден
    }

    public DataItem find(int key) // Поиск элемента с заданным ключом
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc1(key); // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        while (hashArray[hashVal] != null) // Пока не найдена пустая ячейка
        { // Ключ найден?
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // Да, метод возвращает элемент
            hashVal += stepSize; // Прибавление смещения
            hashVal %= arraySize; // Возврат к началу
        }
        return null; // Элемент не найден
    }
}