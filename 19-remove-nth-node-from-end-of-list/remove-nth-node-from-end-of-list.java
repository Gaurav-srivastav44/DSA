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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c=0;
        ListNode curr = head;
        while(curr != null){
            curr =curr.next;
            c++;
        }

        if(n==c)return head.next;

        int tar = c-n-1;
        ListNode curr2 = head;
        while(tar > 0){
            curr2 =curr2.next;
            tar--;
        }
        curr2.next = curr2.next.next;
        return head;
    }
}