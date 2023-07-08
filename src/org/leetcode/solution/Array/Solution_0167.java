package org.leetcode.solution.Array;

import java.util.Arrays;

/**
 * <p>两数之和 2 - 输入有序数组</p>
 * <p>一个下标从 1 开始的整数数组 numbers ，该数组已按<strong>非递减顺序排列</strong>，从数组中找出满足相加之和等于目标数<strong>target</strong>的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。</p>
 *
 * <p>以长度为<strong>2</strong>的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。</p>
 * <p>假设<strong>每个输入</strong>只对应唯一的答案 ，而且你<strong>不可以</strong>重复使用相同的元素。</p>
 * <p>解决方案必须只使用常量级的额外空间。</p>
 *
 *
 * <p>示例 1：</p>
 * <p>输入：numbers = [2,7,11,15], target = 9</p>
 * <p>输出：[1,2]</p>
 * <p>解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。</p>
 *
 * <p>示例 2：</p>
 * <p>输入：numbers = [2,3,4], target = 6</p>
 * <p>输出：[1,3]</p>
 * <p>解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。</p>
 *
 * <p>示例 3：</p>
 * <p>输入：numbers = [-1,0], target = -1</p>
 * <p>输出：[1,2]</p>
 * <p>解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。</p>
 */
public class Solution_0167 {

    /**
     * 双指针
     * 因为元素有序，和小于目标数，小数值向高位移动，和大于目标值，大数值向低位移动
     */
    public static int[] twoSum(int[] numbers, int target){
        int low=0, high=numbers.length-1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[] {low + 1, high + 1};
            } else if(sum < target) {
                ++ low;
            } else {
                -- high;
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
//        int[] numbers = {2,7,11,15};
//        int target = 9;

//        int[] numbers = {2,3,4};
//        int target = 6;
//
        int[] numbers = {-1,0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
