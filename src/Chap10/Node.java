package Chap10;

public class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private final Node[] childArray = new Node[ORDER];
    private final DataItem[] itemArray = new DataItem[ORDER - 1];

    // Связывание узла с потомком
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
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

    // Определение индекса элемента (в пределах узла).
    public int findItem(long key) {
        for (int i = 0; i < ORDER - 1; i++) { //
            if (itemArray[i] == null) {
                break;
            } else if (itemArray[i].dData == key) {
                return i; // Если элемент найден
            }
        }
        return -1; // В противном случае вернуть -1
    }

    public int insertItem(DataItem newItem) {
        // Предполагается, что узел не пуст
        numItems++;                  // Добавление нового элемента
        long newKey = newItem.dData; // Ключ нового элемента

        for (int i = ORDER - 2; i >= 0; i--) {       // Начиная справа проверяем элементы
            if (itemArray[i] == null) {              // Если ячейка пуста
                continue;                            // перейти на одну ячейку влево
            } else {                                 // Если нет
                long itsKey = itemArray[i].dData;    // Получить ее ключ
                if (newKey < itsKey) {               // Если новый ключ больше
                    itemArray[i + 1] = itemArray[i]; // Сдвинуть вправо
                } else {
                    itemArray[i + 1] = newItem;      // Вставка нового элемента
                    return i + 1;                    // Метод возвращает индекс нового элемента
                }
            }
        }

        itemArray[0] = newItem; // Все элементы сдвинуты, вставка нового элемента
        return 0;
    }

    public DataItem removeItem() { // Удаление наибольшего элемента
        // Предполагается, что узел не пуст
        DataItem temp = itemArray[numItems - 1]; // Сохранение элемента
        itemArray[numItems - 1] = null;          // Отсоединение
        numItems--;                              // На один элемент меньше
        return temp;                             // Метод возвращает удаленный элемент
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }
}
