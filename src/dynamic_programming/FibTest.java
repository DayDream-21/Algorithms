package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibTest {
    public static void main(String[] args) {
        System.out.println("Classic implementation: ");
        System.out.println("Fib 4 = " + fib(4));
        System.out.println("Fib 7 = " + fib(7));
        System.out.println("Fib 12 = " + fib(12));

        System.out.println("Memoization implementation: ");

        System.out.println("memoFib 4 = " + getFibonacci(4));
        System.out.println("memoFib 7 = " + getFibonacci(7));
        System.out.println("memoFib 12 = " + getFibonacci(12));
        System.out.println("memoFib 50 = " + getFibonacci(50));
    }

    // Classic implementation
    // Time complexity O(2^n) BAD!
    // Space complexity O(n)
    private static int fib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Memoization implementation
    private static Map<Long, Long> memoMap;
    static {
        memoMap = new HashMap<>();
        memoMap.put(0L, 0L);
        memoMap.put(1L, 1L);
    }

    private static Long memoFib(long n) {
        if (n == 0) {
            return 0L;
        } else if (n == 1) {
            return 1L;
        } else {
            if (memoMap.containsKey(n)) {
                return memoMap.get(n);
            } else {
                long newFib = memoFib(n - 2) + memoFib(n - 1);
                memoMap.put(n, newFib);
                return newFib;
            }
        }
    }

    // Without map
    // Time complexity O(n)
    // Space complexity O(n)
    public static long getFibonacci(long n) {
        long[] f = new long[(int) (n + 1)];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[(int) n];
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public long getFibonacciLessSpace(long n) {
        if(n <= 1) {
            return n;
        }
        long x = 0, y = 1;
        long ans = 0;
        for(int i=2;i<=n;i++) {
            ans = x + y;
            x = y;
            y = ans;
        }
        return ans;
    }
}
