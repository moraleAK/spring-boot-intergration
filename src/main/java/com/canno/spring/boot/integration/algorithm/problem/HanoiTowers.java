package com.canno.spring.boot.integration.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Canno
 * @since 2018/7/10 11:19
 */
public class HanoiTowers {
    /**
     *  there has  a b c,
     *  f(n) = 2f(n - 1) + 1
     *  f(1) = 1
     *  => f(n) = 2^n - 1
     * @param n
     * @return
     */
    public static int calculate(int n){
        if(n == 1){
            return 1;
        }
        int fn1 = 1;
        int sum = 0;
        while (n > 1){
            sum = fn1 * 2 + 1;
            fn1 = sum;
            n --;
        }

        return sum;
    }
//    public void calculate(int n) {
//        long count = 0;
//        List<Integer> a = new LinkedList<>();
//        List<Integer> b = new LinkedList<>();
//        List<Integer> c = new LinkedList<>();
//        for (int i = n; i > 0; i++) {
//            a.add(i);
//        }
//        b.add(n + 1);
//        c.add(n + 1);
//        while (c.size() < 65){
//            if (c.get(c.size() -1) > a.get(a.get(a.size() - 1))){
//                c.add(a.get(a.size() - 1));
//                ((LinkedList<Integer>) a).remove(a.size() -1);
//            }
//
////            if(0)
//
//        }
//
//    }

    public static void main(String[] args) {
        for(int i = 0; i < 10 ; i ++) {
            System.out.println(calculate(i));
        }
    }
}
