package data_structure_and_algorithms.Chap11;

public class HashFunc {
    public static void main(String[] args) {

    }

    public static int hashFunc1(String key, int arraySize) {
        int hashVal = 0;
        int pow27 = 1;

        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;
            hashVal += pow27 * letter;
            pow27 *= 27;
        }
        return hashVal % arraySize;
    }

    public static int hashFunc2(String key, int arraySize) {
        int hashVal = key.charAt(0) - 96;

        for (int i = 1; i < key.length(); i++) {
            int letter = key.charAt(i) - 96;
            hashVal = hashVal * 27 + letter;
        }
        return hashVal % arraySize;
    }

    public static int hashFunc3(String key, int arraySize) {
        int hashVal = 0;

        for (int j = 0; j < key.length(); j++) { // Слева направо
            int letter = key.charAt(j) - 96; // Получение кода символа
            hashVal = (hashVal * 27 + letter) % arraySize; // Оператор %
        }
        return hashVal; // Без оператора %
    }
}
