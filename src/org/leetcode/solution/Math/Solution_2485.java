package org.leetcode.solution.Math;

/**
 * 数学类：中枢整数
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。
 */
public class Solution_2485 {

    /**
     * x*(1+x)/2 = (n-x+1)(n+x)/2  ==>  x + x*x = n*n + x*n -x*n +n -x*x +x
     * ==>  2*x*x = n * (n+1) / 2
     */
    public static int pivotInteger(int n){
        int sum = n * (n + 1) / 2 , x = (int)Math.sqrt(sum);
        return x * x == sum ? x : -1;
    }

    public static void main(String[] args) {
        System.out.println(0x10.0p-3);

    }
}
