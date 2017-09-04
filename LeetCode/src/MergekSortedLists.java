import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergekSortedLists {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> priQueue=new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode hear=new ListNode(-1);
        ListNode tail=hear;
        for(ListNode node:lists) {
            if(node!=null) {
                priQueue.add(node);
            }
        }
        while(!priQueue.isEmpty()){
            ListNode node=priQueue.poll();
            tail.next=node;
            if(node.next!=null) {
                priQueue.add(node.next);
            }
            tail=tail.next;
        }
        return hear.next;
    }
}
