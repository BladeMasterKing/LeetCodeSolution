package org.leetcode.solution.Array;

import java.util.Arrays;

/**
 * <p>最接近的三个数之和</p>
 * <p>给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。</p>
 * <p>返回这三个数的和。</p>
 * <p>假定每组输入只存在恰好一个解。</p>
 *
 * <p>示例 1：</p>
 * <p>输入：nums = [-1,2,1,-4], target = 1</p>
 * <p>输出：2</p>
 * <p>解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。</p>
 *
 * <p>示例 2：</p>
 * <p>输入：nums = [0,0,0], target = 1</p>
 * <p>输出：0</p>
 */
public class Solution_0016 {

    /**
     * 双指针
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, best = 100_000_000;

        while (i < nums.length){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1, k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }

                if(Math.abs(sum -target) < Math.abs(best - target)){
                    best = sum;
                }
                if(sum > target){
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }

            }
            i ++;
        }
        return best;
    }

    public static void main(String[] args) {
        int[] array = {-1,2,1,-4}; int target = 1;

        System.out.println(threeSumClosest(array, target));
    }
}
