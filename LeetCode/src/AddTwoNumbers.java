/**
 * Created by Tang on 2017/9/4.
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode hi=result;
        int carry=0;
        while (l1!=null||l2!=null||carry==1){
            if(l1==null&&l2==null&&carry==1){
                hi.next=new ListNode(carry);
                hi=hi.next;
                break;
            }
            if(l1==null){
                int value=carry+l2.val;
                hi.next=new ListNode(value%10);
                hi=hi.next;
                carry=value/10;
                l2=l2.next;
                continue;
            }
            if(l2==null){
                int value=carry+l1.val;
                hi.next=new ListNode(value%10);
                hi=hi.next;
                carry=value/10;
                l1=l1.next;
                continue;
            }
            int sum=l1.val+l2.val+carry;
            int sumcopy=sum;
            sum=sum%10;
            carry=sumcopy/10;
            if(result==null) {
                result=new ListNode(sum);
                hi=result;
            }
            else {
                hi.next=new ListNode(sum);
                hi=hi.next;
            }
            l1=l1.next;l2=l2.next;
        }
        return result;
    }
}
