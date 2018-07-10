package com.canno.spring.boot.integration.algorithm.problem;

/**
 * @author Canno
 * @since 2018/7/10 12:21
 */
public class Problem {

    /**
     * Judge a num is a prime num
     *
     * @param n
     * @return
     */
    public static boolean isPrimeNum(int n) {
        int nSqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= nSqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Judge a num is narcissistic num.
     * 999 > n  >= 100
     * n = a * 100 + b *10 + c
     * n = a*a*a + b*b*b + c*c*c
     *
     * @param n
     * @return
     */
    public static boolean isNarcissisticNum(int n) {
        int a = n / 100;
        int b = n % 100 / 10;
        int c = n % 100 % 10;
        return n == (a * a * a + b * b * b + c * c * c);
    }

    /**
     * Prime factor decomposition
     * etc:
     * 99 = 3 * 3 * 11
     * 100 = 2 * 2 * 5 * 5
     * 101 = 1 * 101
     *
     * @param n
     */
    public static void primeFactorDecomposition(int n){
        StringBuilder sb = new StringBuilder(n + " = 1 * ");
        int n_ = 1;
        while (n!=1){
            n_ = getDecomposition(n);
            sb.append(n_).append(" * ");
            n = n / n_;
        }
        System.out.println(sb.toString().substring(0, sb.lastIndexOf("*")));
    }

    public static int getDecomposition(int n){
        int nSqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= nSqrt; i++) {
            if (n % i == 0) {
                return i;
            }
        }

        return n;
    }


    public static void main(String[] args) {
        for (int i = 99; i <= 200; i++) {
            primeFactorDecomposition(i);
        }
    }
}
