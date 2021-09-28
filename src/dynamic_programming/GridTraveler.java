package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem:
 * We have a grid (M x N) with a traveler on it.
 * The traveler is in the top left cell and must find
 * the number of paths to the bottom right cell, but it can
 * move only to the right and down.
 * */

public class GridTraveler {
    public static void main(String[] args) throws IOException {
        System.out.println("gridTravelerMemo <<< ans: " + gridTravelerMap(3L, 3L));
        System.out.println("gridTravelerMemo <<< ans: " + gridTravelerMap(18L, 18L));
    }

    private static int gridTraveler(int m, int n) {
        // Base case, if we have 1x1 grid, then there's only one way
        if (m == 1 && n == 1) {
            return 1;
        }
        // Base case, if one dimension = 0, then there's no way
        if (m == 0 || n == 0) {
            return 0;
        }

        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    private static Map<String, Long> memo = new HashMap<>();

    static long gridTravelerMap(long m, long n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        // Generate key
        String key = m + "," + n;

        // Generate value for key
        if (!memo.containsKey(key))
            memo.put(key, gridTravelerMap(m - 1L, n) + gridTravelerMap(m, n - 1));

        return memo.get(key);
    }
}
