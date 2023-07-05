package org.leetcode.solution.Array;

import java.util.Arrays;

/**
 * <p>给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：</p>
 * <p>矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。</p>
 * <p>在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。</p>
 * <p>请你返回最后的 分数 。</p>
 *
 * <p>示例 1：</p>
 * <p>输入：nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]</p>
 * <p>输出：15</p>
 * <p>解释：第一步操作中，我们删除 7 ，6 ，6 和 3 ，将分数增加 7 。下一步操作中，删除 2 ，4 ，5 和 2 ，将分数增加 5 。最后删除 1 ，2 ，3 和 1 ，将分数增加 3 。所以总得分为 7 + 5 + 3 = 15 。</p>
 *
 * <p>示例 2：</p>
 * <p>输入：nums = [[1]]</p>
 * <p>输出：1</p>
 * <p>解释：我们删除 1 并将分数增加 1 ，所以返回 1 。</p>
 */
public class Solution_2679 {

    /**
     * 先将数组排序，之后取每列的最大值相加即可
     */
    public static int matrixSum(int[][] nums){
        int sum = 0;
        for(int[] array : nums){
            Arrays.sort(array);
        }
        for(int i=0; i<nums[0].length; i++){
            int max = 0;
            for(int[] array: nums){
                max = Math.max(max, array[i]);
            }
            sum += max;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = {{1}};
//        System.out.println(matrixSum(a));
        int[][] b = {{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        System.out.println(matrixSum(b));
    }
}
