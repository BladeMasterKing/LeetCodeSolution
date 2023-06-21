package org.leetcode.solution.LinkedList;

/**
 * 两数相加
 * 两个非空链表，表示两个非负整数，每位数字按照 逆序 存储，每个节点只能存储一位数字
 * 两数相加，以相同形式返回表示和的链表
 *
 * 输入：l1 = [2,4,3] l2=[5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 708
 *
 * 输入：l1=[9,9,9,9,9,9,9] l2=[9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,0,1]
 */
public class Solution_01 {

    static class ListNode {
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
    }

    /**
     * 正序遍历链表，存储相加进位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNums(ListNode l1, ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if(null == head){
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(null != l1){
                l1 = l1.next;
            }
            if(null != l2){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
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

    public static String join(int[] array){
        StringBuilder b = new StringBuilder();
        for(int a : array){
            b.append(a);
        }
        return b.toString();
    }
    public static void main(String[] args) {
        int[] a = {2,4,3},b={5,6,4};
        ListNode l1 = buildListNode(a);
        ListNode l2 = buildListNode(b);

        int[] c = {9,9,9,9,9,9,9},d ={9,9,9,9};
         l1 = buildListNode(c);
         l2 = buildListNode(d);
        System.out.println(addTwoNums(l1,l2));
    }
}
