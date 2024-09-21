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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (head1 != null || head2 != null || carry != 0) {
            int digit1 = 0;
            if (head1 != null) {
                digit1 = head1.val;
            }
            int digit2 = 0;
            if (head2 != null) {
                digit2 = head2.val;
            }

            int sum = digit1 + digit2 + carry;
            int over = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(over);
            tail.next = newNode;
            tail = tail.next;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        ListNode res = dummyHead.next;
        //dummyHead.next = null;
        return res;
    }
}