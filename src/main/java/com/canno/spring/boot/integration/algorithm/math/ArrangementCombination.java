package com.canno.spring.boot.integration.algorithm.math;

/**
 * Arrangement and Combination algorithm
 *
 * @author Canno
 * @since 2018/7/9 11:34
 */
public class ArrangementCombination {
    /**
     * calculate A(n,m)
     *
     * @param m take out count
     * @param n total count
     * @return arrangement result
     */
    public static int arrangement(int n, int m) {
///        return factorial(n) / factorial(n - m);
        if (n == m || m == 0) {
            return 1;
        }
        if (n - m < m) {
            m = n - m;
        }

        int product = 1;
        int m_ = n - m;
        while (n > m_) {
            product *= n;
            n--;
        }

        return product;
    }

    /**
     * calculate C(n,m)
     *
     * @param n total count
     * @param m take out count
     * @return combination result
     */
    public static int combination(int n, int m) {
        if (n - m < m) {
            m = n - m;
        }
        return arrangement(n, m) / factorial(m);
    }

    /**
     * calculate product of n
     *
     * @param n count
     * @return product
     */
    public static int factorial(int n) {
        assert n > 0;
        int product = 1;
        while (n > 0) {
            product *= n;
            n--;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(combination(300, 299));
    }
}
