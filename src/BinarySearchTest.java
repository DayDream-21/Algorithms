class OrdArray {
    private int[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new int[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentIndex;

        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (a[currentIndex] == searchKey) {
                return currentIndex;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[currentIndex] < searchKey) {
                    lowerBound = currentIndex++;
                } else {
                    upperBound = currentIndex--;
                }
            }
        }
    }

    public void insert(int value) {
        int j;

        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        nElems++;
    }

    public boolean delete(int value) {
        int j = find(value);
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}

public class BinarySearchTest {
    public static void main(String[] args) {

    }
}
