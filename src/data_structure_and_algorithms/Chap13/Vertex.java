package data_structure_and_algorithms.Chap13;

public class Vertex {
    public char label; // Метка вершины
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
}
