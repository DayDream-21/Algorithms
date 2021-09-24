package data_structure_and_algorithms.Chap14.GraphWeighted;

public class Vertex {
    public char label; // Метка (например, 'A')
    public boolean isInTree;

    public Vertex(char lab) { // Конструктор
        label = lab;
        isInTree = false;
    }

} // Конец класса Vertex
