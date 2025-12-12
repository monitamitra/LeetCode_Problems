# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        prev = None
        curr = head

        while curr:
            # store pointers before changing
            temp_next = curr.next

            # change references
            curr.next = prev

            # move pointers
            prev = curr
            curr = temp_next
        
        return prev

