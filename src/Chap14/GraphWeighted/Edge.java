package Chap14.GraphWeighted;

public class Edge {
    public int srcVert; // Индекс начальной вершины ребра
    public int destVert; // Индекс конечной вершины ребра
    public int distance; // Расстояние от начала до конца
    // Конструктор
    public Edge(int sv, int dv, int d) {
        srcVert = sv;
        destVert = dv;
        distance = d;
    }

}
