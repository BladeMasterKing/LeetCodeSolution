package org.leetcode.solution.String;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>无重复字符的最长子串</p>
 * <p>给定一个字符串 s ，找出其中不含有重复字符的 最长子串 的长度。</p>
 *
 * <p>示例 1:</p>
 * <p>输入: s = "abcabcbb"</p>
 * <p>输出: 3</p>
 * <p>解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。</p>
 *
 * <p>示例 2:</p>
 * <p>输入: s = "bbbbb"</p>
 * <p>输出: 1</p>
 * <p>解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。</p>
 *
 * <p>示例 3:</p>
 * <p>输入: s = "pwwkew"</p>
 * <p>输出: 3</p>
 * <p>解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。</p>
 * <p>注意答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。</p>
 */
public class Solution_0003 {

    /**
     * 使用滑动窗口
     * 从字符串启始位置开始，窗口从左向右遍历字符串，窗口大小递增
     * 通过 set 集合保证窗口字符串不重复
     */
    public static int lengthOfLongestSubstring(String s){

        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk = -1, ans = 0;

        for(int i=0;i< n; i++){
            if(i != 0){
                occ.remove(s.charAt(i-1));
            }
            while(rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                occ.add(s.charAt(rk + 1));
                ++ rk;
            }
            ans = Math.max(ans, rk -i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
