package org.leetcode.solution.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>重构2行二进制数组</p>
 * <p>一个 2 行 n 列的二进制数组：</p>
 * <p>矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。</p>
 * <p>第 0 行的元素之和为 upper。</p>
 * <p>第 1 行的元素之和为 lower。</p>
 * <p>第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。</p>
 *
 * <p>利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。</p>
 * <p>如果不存在返回一个空的二维数组。</p>
 *
 * <p>示例 1：</p>
 * <p>输入：upper = 2, lower = 1, colsum = [1,1,1]</p>
 * <p>输出：[[1,1,0],[0,0,1]]</p>
 * <p>解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。</p>
 *
 * <p>示例 2：</p>
 * <p>输入：upper = 2, lower = 3, colsum = [2,2,1,1]</p>
 * <p>输出：[]</p>
 *
 * <p>示例 3：</p>
 * <p>输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]</p>
 * <p>输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]</p>
 */
public class Solution_1253 {

    /**
     * 题解：贪心
     *
     * 记 sum 为数组 colsum 的元素和，two 为数组 colsum 中 2 的个数。明显当 sum ≠ upper + lower 时，一定不存在满足题意的矩阵。
     * 然后当第 i 列 colsum[i]= 2 时，第 i 列的两个元素只能都为 1。那么如果 two > min{upper,lower} 时，此时同样不存在满足题意的矩阵。
     * 设结果矩阵为 res[2][n]。当第 i 列 colsum[i] 等于 0 或者 2 时只有一种情况：
     *
     * colsum[i]=0 时：res[0][i]=res[1][i]=0。
     * colsum[i]=2 时：res[0][i]=res[1][i]=1。
     * 所以现在我们只关注 colsum[i]=1 的情况。首先我们将初始的 upper 和 lower 减去数组 colsum 中 2 的个数 two，那么现在 upper+lower 为数组 colsum 中 1 的个数。
     * 那么我们将从左到右遍历 colsum 中的每一列，若第 i 列 colsum[i] 等于 1：
     *
     * 若 upper>0，则我们在该列的第一行放置 1，第二行放置 0：res[0][i]=1，res[1][i]=0，并且 upper 减一。
     * 否则我们在该列的第一行放置 0，第二行放置 1：res[0][i]=0，res[1][i]=1。
     * 当遍历完成后就得到了符合题目要求的矩阵 res[2][n]。
     */
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List out = new ArrayList<>();
        List col1 = new ArrayList();
        List col2 = new ArrayList();
        int sum = 0, count_2 = 0;
        for(int col : colsum){
            sum += col;
            if(col == 2)
                count_2++;
        }
        //
        if(upper + lower != sum || Math.min(upper, lower) < count_2){
            return out;
        }

        int upper_no2 = upper - count_2;

        for (int col: colsum) {

            if(col == 0){
                col1.add(0);
                col2.add(0);
            }
            if(col == 2){
                col1.add(1);
                col2.add(1);
            }
            if(col == 1){
                if(upper_no2 > 0){
                    col1.add(1);
                    col2.add(0);
                    upper_no2 --;
                } else {
                    col1.add(0);
                    col2.add(1);
                }
            }
        }
        out.add(col1);
        out.add(col2);

        return out;
    }

    public static void main(String[] args) {
//        int upper = 2, lower = 1;
//        int[] colsum = {1,1,1};

//        int upper = 2, lower = 3;
//        int[] colsum = {2,2,1,1};

        int upper = 5, lower = 5;
        int[] colsum = {2,1,2,0,1,0,1,2,0,1};
        System.out.println(reconstructMatrix(upper, lower, colsum));
    }
}
