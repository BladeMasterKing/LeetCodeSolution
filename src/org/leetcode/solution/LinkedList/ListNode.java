package org.leetcode.solution.LinkedList;

/**
 * @author wangjiansheng
 * @version 1.0.0
 * @date 2023/7/10 15:37
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        ListNode n = this;
        while (null != n){
            b.append(n.val);
            n = n.next;
        }
        return b.toString();
    }

    public static ListNode buildListNode(int[] array){
        ListNode node= new ListNode(Integer.parseInt(String.valueOf(array[0])));
        ListNode next = node;
        int i = 1;
        while (i<array.length){
            next.next = new ListNode(Integer.parseInt(String.valueOf(array[i])));
            next = next.next;
            i++;
        }

        return node;
    }
}
