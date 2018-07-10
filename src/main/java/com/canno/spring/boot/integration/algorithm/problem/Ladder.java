package com.canno.spring.boot.integration.algorithm.problem;

/**
 * There has a ladder of  n steps.
 * You can move one or two steps each time.
 * Then, how many ways when from one step to the end?
 *
 * @author Canno
 * @since 2018/7/10 10:13
 */
public class Ladder {
    /**
     * Each time can move one or two steps.
     * we know (n -2) + 2 = n or (n - 1) + 1 = n.
     * So, deduced f(n) = f(n - 1) + f(n - 2)
     * Yes, it is a Fibonacci sequence
     *
     * @param n steps
     * @return all ways
     */
    public static int calculate(int n) {
        assert n > 0;
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int fn2 = 1;
        int fn1 = 2;
        int sum = 0;
        while (n > 2) {
            sum = fn2 + fn1;
            fn2 = fn1;
            fn1 = sum;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate(0));
    }
}
