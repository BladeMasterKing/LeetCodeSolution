package org.leetcode.solution.Array;

import java.util.HashMap;
import java.util.Map;
/**
 * 题目：0001
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，
 * 并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Solution_0001 {


	
	/**
	 * 暴力枚举
	 */
	public int[] q0001Soluiton1(int[] nums, int target) {
		for(int i=0;i<nums.length;++i) {
			for(int j=i+1;j<nums.length;++j) {
				if(i != j && target == nums[i]+nums[j]) {
					return new int[] {i,j};
				}
			}
		}
		return new int[0];
	}
	
	/**
	 * 哈希表
	 */
	public int[] q0001Solution2(int[] nums, int target) {
		Map<Integer,Integer> hashTable = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;++i) {
			if(hashTable.containsKey(target - nums[i])){
				return new int[] {i, hashTable.get(target - nums[i]), i};
			}
			hashTable.put(nums[i], i);
		}
		return new int[0];
	}
	
	
	/**
	 * 一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
	 * 被2和3整除，就是6的倍数
	 */
	public static int q2455Solution1(int[] nums) {
		int sum = 0;
		int count = 0;
		for(int num : nums) {
			if(num % 6 == 0 ) {
				sum += num;
				count ++;
			}
		}
		if(count > 0) {
			return Math.round(sum / count);
		}
		return 0;
	}
	

}
