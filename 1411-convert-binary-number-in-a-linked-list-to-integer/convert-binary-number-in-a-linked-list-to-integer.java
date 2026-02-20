/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode curr = head;
        while(curr != null){
            sb.append(curr.val);
            curr = curr.next;
        }

        BigInteger a = new BigInteger(sb.toString(), 2);
        return a.intValue();

    }
}