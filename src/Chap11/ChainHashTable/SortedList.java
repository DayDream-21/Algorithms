package Chap11.ChainHashTable;

public class SortedList {
    private Link first; // Ссылка на первый элемент списка

    public SortedList() // Конструктор
    {
        first = null;
    }

    public void insert(Link theLink) // Вставка в порядке сортировки
    {
        int key = theLink.getKey();
        Link previous = null; // Начиная с первого элемента
        Link current = first;
        // До конца списка
        while (current != null && key > current.getKey()) { // Или пока current <= key
            previous = current;
            current = current.next; // Переход к следующему элементу
        }
        if (previous == null) // В начале списка
            first = theLink; // first --> новый элемент
        else // Не в начале
            previous.next = theLink; // prev --> новый элемент
        theLink.next = current; // новый элемент --> current
    }

    public void delete(int key) // Удаление элемента
    { // (предполагается, что список не пуст)
        Link previous = null; // Начиная с первого элемента
        Link current = first;
// До конца списка
        while (current != null && key != current.getKey()) { // или пока key != current
            previous = current;
            current = current.next; // Переход к следующему элементу
        }
// Отсоединение
        if (previous == null) // Если первый элемент,
        {
            assert first != null;
            first = first.next; // изменить first
        }
        else // В противном случае
        {
            assert current != null;
            previous.next = current.next; // удалить текущий элемент
        }
    } // end delete()

    public Link find(int key) // Поиск элемента с заданным ключом
    {
        Link current = first; // Начиная от начала списка
// До конца списка
        while (current != null && current.getKey() <= key) { // или пока ключ не превысит current,
            if (current.getKey() == key) // Искомый элемент?
                return current; // Совпадение обнаружено
            current = current.next; // Переход к следующему элементу
        }
        return null; // Элемент не найден
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while (current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println();
    }
}