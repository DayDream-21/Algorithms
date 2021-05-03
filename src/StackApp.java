class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

public class StackApp {
    public static void main(String[] args) {
        Stack theStack = new Stack(10); // Создание нового стека
        theStack.push(20); // Занесение элементов в стек
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while( !theStack.isEmpty() ) // Пока стек не станет пустым
        { // Удалить элемент из стека
            long value = theStack.pop();
            System.out.println(value); // Вывод содержимого
        }
        System.out.println();
    }
}



