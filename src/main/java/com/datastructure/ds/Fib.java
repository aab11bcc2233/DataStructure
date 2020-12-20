package com.datastructure.ds;

public class Fib {

    public long fib(long n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public long fib2(long n) {
        if (n==0) {
            return 0;
        }
        long[] memo = new long[(int) (n + 1)];
        return helper(memo, n);
    }

    private long helper(long[] memo, long n) {
        if (n <= 2) {
            return 1;
        }
        long num = memo[(int) n];
        if (num > 0) {
            return num;
        }

        num = helper(memo, n - 1) + helper(memo, n - 2);

        memo[(int) n] = num;

        return num;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Fib().fib(100);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
