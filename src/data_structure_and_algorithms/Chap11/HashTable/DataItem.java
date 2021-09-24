package data_structure_and_algorithms.Chap11.HashTable;

public class DataItem { // (Данных может быть и больше)
    private int iData; // Данные (ключ)
    // Конструктор
    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }

}
