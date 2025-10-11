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
        ListNode temp = head;
        int c=0;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        if (n == c) {
            return head.next;
        }
        int x=c-n-1;
        temp = head;
        while(x>0){
            temp = temp.next;
            x--;
        }
        temp.next = temp.next.next;
        return head;


    }
}