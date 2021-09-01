package Chap14.GraphWeighted;

public class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList; // Список вершин
    private int[][] adjMat; // Матрица смежности
    private int nVerts; // Текущее количество вершин
    private int currentVert;
    private PriorityQ thePQ;
    private int nTree; // Количество вершин в дереве

    public Graph() // Конструктор
    {
        vertexList = new Vertex[MAX_VERTS];
        // Матрица смежности
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        // Матрица смежности заполняется нулями
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        thePQ = new PriorityQ();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    // Построение минимального остовного дерева
    public void mstw() {
        currentVert = 0; // Начиная с ячейки 0
        while (nTree < nVerts - 1) { // Пока не все вершины включены в дерево
            vertexList[currentVert].isInTree = true; // Включение currentVert в дерево
            nTree++;
            // Вставка в приоритетную очередь ребер, смежных с currentVert
            for (int j = 0; j < nVerts; j++) { // Для каждой вершины
                if (j == currentVert) { // Пропустить, если текущая вершина
                    continue;
                }

                if (vertexList[j].isInTree) { // Пропустить, если уже в дереве
                    continue;
                }

                int distance = adjMat[currentVert][j];

                if (distance == INFINITY) { // Пропустить, если нет ребер
                    continue;
                }
                putInPQ(j, distance); // Поместить в приоритетную очередь
            }

            if (thePQ.size() == 0) {// Очередь не содержит вершин?
                System.out.println(" GRAPH NOT CONNECTED");
                return;
            }
            // Удаление ребра с минимальным расстоянием из очереди
            Edge theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;
            // Вывод ребра от начальной до текущей вершины
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }
        // Минимальное остовное дерево построено
        for (int j = 0; j < nVerts; j++) { // Снятие пометки с вершин
            vertexList[j].isInTree = false;
        }
    }

    public void putInPQ(int newVert, int newDist) {
        // Существует ли другое ребро с той же конечной вершиной?
        int queueIndex = thePQ.find(newVert); // Получение индекса
        if (queueIndex != -1) { // Если ребро существует,
            Edge tempEdge = thePQ.peekN(queueIndex); // получить его
            int oldDist = tempEdge.distance;

            if (oldDist > newDist) { // Если новое ребро короче,
                thePQ.removeN(queueIndex); // удалить старое ребро
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                thePQ.insert(theEdge); // Вставка нового ребра
            }
        // Иначе ничего не делается; оставляем старую вершину
        } else { // Ребра с той же конечной вершиной не существует
            Edge theEdge = new Edge(currentVert, newVert, newDist); // Вставка нового ребра
            thePQ.insert(theEdge);
        }
    }
}