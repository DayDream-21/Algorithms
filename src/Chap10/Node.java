package Chap10;

class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private final Node[] childArray = new Node[ORDER];
    private final DataItem[] itemArray = new DataItem[ORDER - 1];

    // Связывание узла с потомком
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null)
            child.parent = this;
    }

    // Метод отсоединяет потомка от узла и возвращает его
    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    // Получение объекта DataItem с заданным индексом
    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    // Определение индекса элемента (в пределах узла)
    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) { // Если элемент найден
            if (itemArray[j] == null) { // В противном случае
                break; // Вернуть -1
            } else if (itemArray[j].dData == key) {
                return j;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        // Предполагается, что узел не пуст
        numItems++; // Добавление нового элемента
        long newKey = newItem.dData; // Ключ нового элемента
        for (int j = ORDER - 2; j >= 0; j--) // Начиная справа,
        { // проверяем элементы
            if (itemArray[j] == null) { // Если ячейка пуста,
                continue; // перейти на одну ячейку влево
            } else { // Если нет,
                // получить ее ключ
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey) {// Если новый ключ больше
                    itemArray[j + 1] = itemArray[j]; // Сдвинуть вправо
                } else {
                    itemArray[j + 1] = newItem; // Вставка нового элемента
                    return j + 1; // Метод возвращает индекс
                } // нового элемента
            }
        } // Все элементы сдвинуты,
        itemArray[0] = newItem; // вставка нового элемента
        return 0;
    }

    public DataItem removeItem() { // Удаление наибольшего элемента
        // Предполагается, что узел не пуст
        DataItem temp = itemArray[numItems - 1]; // Сохранение элемента
        itemArray[numItems - 1] = null; // Отсоединение
        numItems--; // На один элемент меньше
        return temp; // Метод возвращает удаленный элемент
    }

    public void displayNode() { // Формат "/24/56/74/"
        for (int j = 0; j < numItems; j++) {
            itemArray[j].displayItem(); // "/56"
        }
        System.out.println("/"); // Завершающий символ "/"
    }
}