package data_structure_and_algorithms.Chap04;

class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        nItems = 0;
    }

    public void insert(int item) {
        int i;

        if (nItems == 0) {
            queueArray[nItems++] = item;
        } else {
            for (i = nItems - 1; i >= 0; i--) {
                if (item > queueArray[i]) {
                    queueArray[i + 1] = queueArray[i];
                } else {
                    break;
                }
            }
            queueArray[i + 1] = item;
            nItems++;
        }
    }

    public int remove () {
        return queueArray[--nItems];
    }

    public int peekMin () {
        return queueArray[nItems - 1];
    }

    public boolean isEmpty () {
        return (nItems == 0);
    }

    public boolean isFull () {
        return (nItems == maxSize);
    }
}

public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);

        while (!priorityQueue.isEmpty()) {
            int item = priorityQueue.remove();
            System.out.print(item + " ");
        }
    }
}
