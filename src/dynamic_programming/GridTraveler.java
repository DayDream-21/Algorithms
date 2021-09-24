package dynamic_programming;

/*
* Problem:
* We have a grid (M x N) with a traveler on it.
* The traveler is in the top left cell and must find
* the number of paths to the bottom right cell, but it can
* move only to the right and down.
* */

public class GridTraveler {
    public static void main(String[] args) {
        System.out.println(findNumberOfPaths(5, 4));
    }

    private static int findNumberOfPaths(int m, int n) {
        // Base case, if we have 1x1 grid, then there's only one way
        if (m == 1 && n == 1) {
            return 1;
        }
        // Base case, if one dimension = 0, then there's no way
        if (m == 0 || n == 0) {
            return 0;
        }

        return findNumberOfPaths(m - 1, n) + findNumberOfPaths(m, n - 1);
    }
}
