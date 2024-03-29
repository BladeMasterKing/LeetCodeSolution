package org.leetcode.solution.Array;

import java.util.Arrays;

/**
 * <h2>下降路径最小和</h2>
 * <p>给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。</p>
 * <p>下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。</p>
 *
 *
 *
 * <p>示例 1：</p>
 * <p>输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]</p>
 * <p>输出：13</p>
 * <p>解释：如图所示，为和最小的两条下降路径</p>
 *
 * <p>示例 2：</p>
 * <p>输入：matrix = [[-19,57],[-40,-5]]</p>
 * <p>输出：-59</p>
 * <p>解释：如图所示，为和最小的下降路径</p>
 */
public class Solution_0931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mn = dp[i - 1][j];
                if (j > 0) {
                    mn = Math.min(mn, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    mn = Math.min(mn, dp[i - 1][j + 1]);
                }
                dp[i][j] = mn + matrix[i][j];
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

}
