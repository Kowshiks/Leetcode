# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        
        first, second = head, head.next
        
        i = 1
        
        while second and second.next:
                
            first = first.next
            
            second = second.next.next
            
            i+=1
            
        if second:
            
            val = i + i + 1 - k
                    
        else:
            
            val = i + i - k
           
        tmp = head
        
        index = 1
        
        while tmp:
            
            if index == k:
                
                first_node = tmp
            
            if index == val:
                
                second_node = tmp
                
            tmp = tmp.next
            
            index +=1
            
        tmp = first_node.val
        
        first_node.val = second_node.val
        
        second_node.val = tmp
        
        return head
