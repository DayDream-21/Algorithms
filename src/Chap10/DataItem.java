package Chap10;

public class DataItem {
    public long dData; // Один объект данных

    public DataItem(long dData) { // Конструктор
        this.dData = dData;
    }

    public void displayItem() {
        System.out.println("/" + dData);
    }
}
