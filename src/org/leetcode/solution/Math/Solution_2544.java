package org.leetcode.solution.Math;

/**
 * <h2>交替数字和</h2>
 * <p>给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：</p>
 * <ul>
 *     <li><strong>最高有效位</strong>上的数字分配到<strong>正</strong>号。</li>
 *     <li>剩余每位上数字的符号都与其相邻数字相反。</li>
 *     <li>返回所有数字及其对应符号的和。</li>
 * </ul>
 *
 * <p>示例 1：</p>
 * <p>输入：n = 521</p>
 * <p>输出：4</p>
 * <p>解释：(+5) + (-2) + (+1) = 4</p>
 *
 * <p>示例 2：</p>
 * <p>输入：n = 111</p>
 * <p>输出：1</p>
 * <p>解释：(+1) + (-1) + (+1) = 1</p>
 *
 * <p>示例 3：</p>
 * <p>输入：n = 886996</p>
 * <p>输出：0</p>
 * <p>解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0</p>
 */
public class Solution_2544 {
    public static int alternateDigitSum(int n) {
        int result = 0;
        while (n > 0){
            result = n % 10 - result;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521));
        System.out.println(alternateDigitSum(111));
        System.out.println(alternateDigitSum(886996));
    }
}
