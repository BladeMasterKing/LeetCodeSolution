package org.leetcode.solution.Math;

/**
 * <p>袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。</p>
 * <p>给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。</p>
 * <p>袋子最初包含：</p>
 * <p>numOnes 件标记为 1 的物品。</p>
 * <p>numZeroes 件标记为 0 的物品。</p>
 * <p>numNegOnes 件标记为 -1 的物品。</p>
 * <p>现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。</p>
 *
 * <p>示例 1：</p>
 * <p>输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2</p>
 * <p>输出：2</p>
 * <p>解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。</p>
 * <p>可以证明 2 是所有可行方案中的最大值。</p>
 *
 * <p>示例 2：</p>
 * <p>输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4</p>
 * <p>输出：3</p>
 * <p>解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 3 件标记为 1 的物品，1 件标记为 0 的物品，得到的数字之和为 3 。</p>
 * <p>可以证明 3 是所有可行方案中的最大值。</p>
 */
public class Solution_2600 {

    /**
     * 贪心
     * 先从数字 1 取，数字 1 的数量小于 k 在从数字 0 取，依次类推
     */
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k <= numOnes){
            return k;
        }
        if(k > numOnes && k <= numOnes+numZeros){
            return numOnes;
        }
        if(k > numOnes + numZeros && k<= numOnes + numZeros + numNegOnes){
            return numOnes - (k- numOnes -numZeros);
        }
        return 0;
    }

    public static void main(String[] args) {
        int numOnes=6, numZeros=6, numNegOnes=6;
        System.out.println(kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, 13));
    }
}
