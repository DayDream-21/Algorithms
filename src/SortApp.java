class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.print("Last name: " + lastName + "; ");
        System.out.print("\tFirst name: " + firstName + "; ");
        System.out.println("\tAge: " + age);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Array {
    private Person[] a;
    private int nElems;

    public Array(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            a[i].displayPerson();
        }
        System.out.println();
    }

    public void bubbleSort() {
        int out;
        int in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in].getLastName().compareTo(a[in + 1].getLastName()) > 0) {
                    swap(in, in + 1);
                }
            }
        }
    }

    public void bubbleSortReverse() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].getLastName().compareTo(a[j + 1].getLastName()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void selectionSort() {
        int out;
        int in;
        int min;

        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in].getLastName().compareTo(a[in + 1].getLastName()) > 0) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    public void insertionSort() {
        int in;
        int out;

        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;
            while (in > 0 &&
                    a[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }
    }

    private void swap(int one, int two) {
        Person temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

public class SortApp {
    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        Array arr; // Ссылка на массив
        arr = new Array(maxSize);// Создание массива

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting: ");
        arr.display(); // Вывод элементов
        arr.insertionSort(); // Пузырьковая сортировка элементов
        System.out.println("After sorting: ");
        arr.display(); // Повторный вывод
    }
}

