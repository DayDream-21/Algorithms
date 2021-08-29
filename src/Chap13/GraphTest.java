package Chap13;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph();
        // Добавляем вершины
        graph.addVertex('A'); // 0 - исходная вершина
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        // Указываем связи между вершинами
        graph.addEdge(0, 1); // AB
        graph.addEdge(1, 2); // BC
        graph.addEdge(0, 3); // AD
        graph.addEdge(3, 4); // DE

        System.out.println("Visits: ");
        graph.dfs(); // Выполняем обход
    }
}
