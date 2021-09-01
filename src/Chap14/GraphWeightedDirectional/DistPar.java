package Chap14.GraphWeightedDirectional;

// Расстояние и родительская вершина
// Объекты сохраняются в массиве sPath
public class DistPar {
    public int distance; // Расстояние от начальной вершины до текущей
    public int parentVert; // Текущий родитель вершины
    // Конструктор
    public DistPar(int pv, int d) {
        distance = d;
        parentVert = pv;
    }
}
