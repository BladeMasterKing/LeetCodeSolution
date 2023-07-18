package org.leetcode.solution.LinkedList;

import java.util.Stack;

/**
 * 两数相加 2
 * <P>给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。</P>
 * <p>假设除了数字 0 之外，这两个数字都不会以零开头。</P>
 *
 * <p>示例1：</P>
 * <p>输入：l1 = [7,2,4,3], l2 = [5,6,4]</P>
 * <p>输出：[7,8,0,7]</P>
 *
 * <p>示例2：</P>
 * <p>输入：l1 = [2,4,3], l2 = [5,6,4]</P>
 * <p>输出：[8,0,7]</P>
 *
 * <p>示例3：</P>
 * <p>输入：l1 = [0], l2 = [0]</P>
 * <p>输出：[0]</P>
 */
public class Solution_0445 {

    /**
     * 通过栈的后进先出来控制
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>  stack1 = new Stack<>();
        while (null != l1){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        Stack<Integer>  stack2 = new Stack<>();
        while (null != l2){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode root = null;
        while (!stack1.empty() || !stack2.empty()){
            int a = stack1.empty() ? 0 : stack1.pop();
            int b = stack2.empty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            carry = sum / 10 ;
            sum %= 10;
            ListNode cur = new ListNode(sum);
            cur.next = root;
            root = cur;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] array1 = {7,2,4,3},  array2 = {3,5,6,4};
        ListNode l1 = ListNode.buildListNode(array1);
        ListNode l2 = ListNode.buildListNode(array2);


        System.out.println(addTwoNumbers(l1, l2));
    }
}
