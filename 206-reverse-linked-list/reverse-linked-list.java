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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            // store og next pointer
            next = curr.next;
            
            // reverse the link
            curr.next = prev;

            // update pointers
            prev = curr;
            curr = next;
        }

        // tail of old list becomes head of new list
        return prev;
    }
}