package data_structure_and_algorithms.Chap12;

public class Node {
    private int iData; // Данные (ключ)
    // -------------------------------------------------------------
    public Node(int key) // Конструктор
    { iData = key; }
    // -------------------------------------------------------------
    public int getKey()
    { return iData; }
    // -------------------------------------------------------------
    public void setKey(int id)
    { iData = id; }
// -------------------------------------------------------------
}
