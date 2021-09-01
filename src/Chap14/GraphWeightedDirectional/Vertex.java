package Chap14.GraphWeightedDirectional;

public class Vertex {
    public char label; // Метка (например, 'A')
    public boolean isInTree;

    public Vertex(char lab) { // Конструктор
        label = lab;
        isInTree = false;
    }
}
