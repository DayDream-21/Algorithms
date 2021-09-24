package data_structure_and_algorithms.Chap06;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(triangle(4));
        System.out.println(factorial(4));
    }

    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n + triangle(n - 1));
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }
}

