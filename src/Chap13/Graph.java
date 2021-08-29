package Chap13;

import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList; // Массив вершин
    private int[][] adjMat; // Матрица смежности
    private int nVerts; // Текущее количество вершин
    Stack<Integer> theStack = new Stack<>();

    public Graph() { // Конструктор
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        // Заполняем нулями матрицу смежности
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    // В аргумент передается метка
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.print(vertexList[vertex].label);
    }

    // Проверяем есть ли у вершины смежная вершина и если есть, то получает ее номер
    public int getAdjUnvisitedVertex(int vertex) {
        for (int i = 0; i < nVerts; i++) {
            // Просматриваем строку заданной вершины и отбираем столбцы, содержащие 1,
            // номер столбца определяет номер смежной вершины. Далее проверяем,
            // посещалась ли вершина ранее
            if ((adjMat[vertex][i] == 1) && (!vertexList[i].wasVisited)) {
                return i; // Возвращает первую найденную вершину
            }
        }
        return -1; // Таких вершин нет
    }

    // Обход в глубину
    public void dfs() {
        // Начинаем обход с вершины 0
        vertexList[0].wasVisited = true; // Пометка о посещении
        displayVertex(0); // Вывод в консоль
        theStack.push(0); // Занесение в стек
        // Пока не опустеет стек
        while (!theStack.isEmpty()) {
            // Получаем не посещенную вершину, смежную к текущей
            int vertex = getAdjUnvisitedVertex(theStack.peek());
            if (vertex == -1) { // Если такой вершины нет,
                theStack.pop(); // извлекаем элемент из стека
            } else { // Если найдена
                vertexList[vertex].wasVisited = true; // Пометка о посещении
                displayVertex(vertex); // Вывод в консоль
                theStack.push(vertex); // Занесение в стек
            }
        }
        // После завершения работы (стек пуст) сбрасываем значение пометок
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited  = false;
        }
    }
}

























