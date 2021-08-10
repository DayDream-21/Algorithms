package Chap10;

public class Tree234 {
    private Node root = new Node(); // Создание корневого узла

    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while(true) {
            if ((childNumber = curNode.findItem(key)) != -1) {
                return childNumber; // Узел найден
            } else if (curNode.isLeaf()) {
                return -1; // Узел не найден
            } else {       // Искать глубже
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public void insert(long dValue) {
        Node curNode  = root;
        DataItem tempItem = new DataItem(dValue);

        while (true) {
            if (curNode.isFull()) {            // Если узел полон
                split(curNode);                // он разбивается
                curNode = curNode.getParent(); // Поиск
                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf()) {     // Если узел листовой
                break;                         // переход к вставке
            } else { // Узел не полный и не листовой: спуститься уровнем ниже
                curNode = getNextChild(curNode, dValue);
            }

            curNode.insertItem(tempItem); // Вставка нового объекта DataItem
        }
    }

    public void split(Node thisNode) { // Разбиение узла
        // Предполагается, что узел полон
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();               // Удаление элементов
        itemB = thisNode.removeItem();               // из текущего узла
        child2 = thisNode.disconnectChild(2);        // Отсоединение потомков
        child3 = thisNode.disconnectChild(3);        // от текущего узла
        Node newRight = new Node();                  // Создание нового узла

        if (thisNode == root) {                      // Если узел является корнем
            root = new Node();                       // Создание нового корня
            parent = root;                           // Корень становится родителем
            root.connectChild(0, thisNode); // Связывание с родителем
        } else {
            parent = thisNode.getParent();           // Получение родителя
        }
        // Операции с родителем
        itemIndex = parent.insertItem(itemB);         // B вставляется в родителя
        int n = parent.getNumItems();                 // Всего элементов?

        for (int i = n - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);     // Перемещение связей родителя
            parent.connectChild(i + 1, temp); // на одного потомка вправо
        }
        // Связывание newRight с родителем
        parent.connectChild(itemIndex + 1, newRight);
        // Операции с узлом newRight
        newRight.insertItem(itemC);                 // Элемент C в newRight
        newRight.connectChild(0, child2); // Связывание 0 и 1
        newRight.connectChild(1, child3); // с newRight
    }

    public Node getNextChild(Node theNode, long theValue) {
        int i;
        // Предполагается, что узел не пуст, не полон и не является листом
        int numItems = theNode.getNumItems();
        for (i = 0; i < numItems; i++) {               // Для каждого элемента в узле
            if (theValue < theNode.getItem(i).dData) { // Наше значение меньше?
                return theNode.getChild(i);            // Тогда возвращаем левого потомка
            }
        }
        return theNode.getChild(i);                    // Иначе возвращаем правого потомка
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level = " + level + " child = " + childNumber + " ");
        thisNode.displayNode(); // Вывод содержимого узла
        // Рекурсивный вызов для каждого потомка текущего узла
        int numItems = thisNode.getNumItems();
        for (int i = 0; i < numItems + 1; i++) {
            Node nextNode = thisNode.getChild(i);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, i);
            } else {
                return;
            }
        }
    }
}
