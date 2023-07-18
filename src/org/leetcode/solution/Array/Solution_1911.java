package org.leetcode.solution.Array;

/**
 * <p>最大子序列交替和</p>
 * <p>一个下标从 0 开始的数组的<strong>交替和</strong>定义为<strong>偶数</strong>下标处元素之<strong>和</strong>减去<strong>奇数</strong>下标处元素之<strong>和</strong>。</p>
 * <p>比如，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。</p>
 * <p>给定一个数组<strong>nums</strong>，返回<strong>nums</strong>中任意子序列的<strong>最大交替和</strong>（子序列的下标<strong>重新</strong>从<strong>0</strong>开始编号）。</p>
 * <p>一个数组的<strong>子序列</strong>是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。
 * 比如，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。</p>
 *
 * <p>示例 1：</p>
 * <p>输入：nums = [4,2,5,3]</p>
 * <p>输出：7</p>
 * <p>解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。</p>
 *
 * <p>示例 2：</p>
 * <p>输入：nums = [5,6,7,8]</p>
 * <p>输出：8</p>
 * <p>解释：最优子序列为 [8] ，交替和为 8 。</p>
 *
 * <p>示例 3：</p>
 * <p>输入：nums = [6,2,1,2,4,5]</p>
 * <p>输出：10</p>
 * <p>解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。</p>
 */
public class Solution_1911 {
    /**
     *
     */
    public static long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i=0; i< nums.length; i++){
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }

    public static void main(String[] args) {
//        int[] nums = {5,6,7,8};
        int[] nums = {4,2,5,3};
        System.out.println(maxAlternatingSum(nums));
    }
}
