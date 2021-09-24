package data_structure_and_algorithms.Chap11.ChainHashTable;

public class Link
{ // (Здесь могут быть другие поля)
    private int iData; // Данные
    public Link next; // Следующий элемент списка
    // -------------------------------------------------------------
    public Link(int it) // Конструктор
    { iData= it; }
// -------------------------------------------------------------
public int getKey()
{ return iData; }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    { System.out.print(iData + " "); }
}