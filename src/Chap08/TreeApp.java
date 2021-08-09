package Chap08;

public class TreeApp {
    public static void main(String[] args) {
        Tree theTree = new Tree(); // Создание дерева
        theTree.insert(50, 1.5); // Вставка трех узлов
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        Node found = theTree.find(25); // Поиск узла с ключом 25
        if (found != null)
            System.out.println("Found the node with key 25");
        else
            System.out.println("Could not find node with key 25");
    }
}

class Node {
    int iData; // Данные, используемые в качестве ключа
    double dData; // Другие данные
    Node leftChild; // Левый потомок узла
    Node rightChild; // Правый потомок узла

    public void displayNode() {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}

class Tree {
    private Node root; // Единственное поле данных

    // Поиск узла с заданным ключом
    // (предполагается, что дерево не пустое)
    public Node find(int key) {
        // Начать с корневого узла
        Node current = root;
        // Пока не найдено совпадение
        while (current.iData != key) {

            if (key < current.iData) {
                current = current.leftChild; // Двигаться налево?
            } else {
                current = current.rightChild; // Или направо?
            }

            if (current == null) { // Если потомка нет,
                return null; // поиск завершился неудачей
            }

        }
        return current; // Элемент найден
    }

    // Вставка узла
    public void insert(int id, double dd) {
        Node newNode = new Node(); // Создание нового узла
        newNode.iData = id; // Вставка данных
        newNode.dData = dd;
        // Корневой узел не существует
        if (root == null) {
            root = newNode;
        } else { // Корневой узел занят
            Node current = root; // Начать с корневого узла
            Node parent;
            // (Внутренний выход из цикла)
            while (true) {
                parent = current;
                if (id < current.iData) { // Двигаться налево?
                    current = current.leftChild;
                    if (current == null) { // Если достигнут конец цепочки
                        parent.leftChild = newNode; // вставить слева
                        return;
                    }
                } else { // Или направо?
                    current = current.rightChild;
                    if (current == null) {  // Если достигнут конец цепочки,
                        parent.rightChild = newNode; // вставить справа
                        return;
                    }
                }
            }
        }
    }

    // Удаление узла с заданным ключом
    // (предполагается, что дерево не пусто)
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) { // Поиск узла
            parent = current;

            if (key < current.iData) { // Двигаться налево?
                isLeftChild = true;
                current = current.leftChild;
            } else { // Или направо?
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) { // Конец цепочки
                return false; // Узел не найден
            }
        }
        // Удаляемый узел найден
        // Если узел не имеет потомков, он просто удаляется.
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) { // Если узел является корневым, дерево очищается
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null; // Узел отсоединяется от родителя
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) { // Если нет правого потомка, узел заменяется левым поддеревом
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) { // Левый потомок родителя
                parent.leftChild = current.leftChild;
            } else {                  // Правый потомок родителя
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) { // Если нет левого потомка, узел заменяется правым поддеревом
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) { // Левый потомок родителя
                parent.leftChild = current.rightChild;
            } else {                  // Правый потомок родителя
                parent.rightChild = current.rightChild;
            }
        } else { // Два потомка, узел заменяется преемником
            // Поиск преемника для удаляемого узла (current)
            Node successor = getSuccessor(current);
            // Родитель current связывается с посредником
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            // Преемник связывается с левым потомком current
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    // Метод возвращает узел со следующим значением после delNode.
    // Для этого он сначала переходит к правому потомку, а затем
    // отслеживает цепочку левых потомков этого узла.
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // Переход к правому потомку
        while (current != null) {// Пока остаются левые потомки
            successorParent = successor;
            successor = current;
            current = current.leftChild; // Переход к левому потомку
        }
        // Если преемник не является
        // правым потомком
        if (successor != delNode.rightChild) {
            // создать связи между узлами
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1 -> {
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
            }
            case 2 -> {
                System.out.print("\nInorder traversal: ");
                inOrder(root);
            }
            case 3 -> {
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
            }
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

}



