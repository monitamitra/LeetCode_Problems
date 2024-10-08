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
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int length = stack.size();
        temp = head;
        for (int i = 0; i < length / 2; i++) {
            ListNode next = temp.next;
            ListNode last = stack.pop();
            temp.next = last;
            last.next = next;
            temp = next;
        }
        temp.next = null;
    }
}