/* https://leetcode.com/problems/intersection-of-two-linked-lists/description/ */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //第一次遍历将会补充2个链表的差异
        //第二次遍历寻找相同节点
        //9-1-2-3-4-5
        //6-7-1-2-3-4-5
        //第一次遍历a是指向7 b会指向9
        if(headA==null||headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while( a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}



