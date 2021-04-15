class HighArray {
    private int[] a; // Ссылка на массив a
    private int nElems; // Количество элементов в массиве

    public HighArray(int max) // Конструктор
    {
        a = new int[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public int getElem(int num) {
        return a[num];
    }

    public boolean find(int searchKey) { // Поиск заданного значения
        int j;
        for (j = 0; j < nElems; j++) // Для каждого элемента
            if (a[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла
        if (j == nElems) // Достигнут последний элемент?
            return false; // Да
        else
            return true; // Нет
    }

    public void insert(int value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public boolean delete(int value) {
        int j;
        for (j = 0; j < nElems; j++) { // Поиск заданного значения
            if (value == a[j]) {
                break;
            }
        }

        if (j == nElems) { // Найти не удалось
            return false;
        } else {
            for (int k = j; k < nElems; k++) { // Сдвиг последующих элементов
                a[k] = a[k + 1];
            }
            nElems--; // Уменьшение размер
            return true;
        }
    }

    public void display() // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }

    public int removeMax() {
        int max = a[0];
        for (int j : a) {
            if (j > max) {
                max = j;
            }
        }

        int j;
        for (j = 0; j < nElems; j++) { // Поиск заданного значения
            if (max == a[j]) {
                break;
            }
        }

        if (j == nElems) { // Найти не удалось
            System.out.println("Not found");
        } else {
            for (int k = j; k < nElems; k++) { // Сдвиг последующих элементов
                a[k] = a[k + 1];
            }
            nElems--; // Уменьшение размер
        }
        System.out.printf("Max number %d deleted\n", max);
        return max;
    }

}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 11; // Размер массива
        HighArray arr; // Ссылка на массив
        arr = new HighArray(maxSize); // Создание массива
        arr.insert(77); // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // Вывод элементов


        HighArray ordArray = new HighArray(10);

        for (int i = 0; i < maxSize; i++) {
            int val = arr.removeMax();
            System.out.println(val);
        }
       //ordArray.display();






        /*int searchKey = 35; // Поиск элемента
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        arr.delete(0); // Удаление трех элементов
        arr.delete(55);
        arr.display(); // Повторный вывод*/


    }
}