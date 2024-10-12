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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // get middle node of list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        // will be last node of new list
        slow.next = null;
        ListNode prev = null;

        // reversing second half of list 
        while (mid != null) {
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }

        // merge two halves of list
        ListNode tail = prev; 
        ListNode beg = head;
        // second half of list could be shorter than first half
        while (tail != null) {
            ListNode temp = beg.next;
            ListNode temp2 = tail.next;
            beg.next = tail;
            tail.next = temp;
            // shift pointers
            beg = temp;
            tail = temp2;
        }
    }
}