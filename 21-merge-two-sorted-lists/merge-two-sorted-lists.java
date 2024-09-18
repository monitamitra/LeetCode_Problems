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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // nothing to merge
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode a = list1;
        ListNode b = list2;
        ListNode head_res = null;
        ListNode tail_res = null;

        // deciding what ListNode to merge first
        if (b.val < a.val) {
            head_res = b;
            tail_res = b;
            b = b.next;
        } else {
            head_res = a;
            tail_res = a;
            a = a.next;
        }

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail_res.next = a;
                tail_res = tail_res.next;
                a = a.next;
            } else {
                tail_res.next = b;
                tail_res = tail_res.next;
                b = b.next;
            }
        }
        if (a != null) {
            tail_res.next = a;
        } else if (b != null) {
            tail_res.next = b;
        }

        return head_res;
    }
}