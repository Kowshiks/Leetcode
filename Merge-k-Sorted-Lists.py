# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        
        cache = {}
        
        val_val = 0
        
        tmp = float('inf')
        
        for i in range(len(lists)):
            
            cache[i] = lists[i]
            
            val_val+=1
            
        node = ListNode()
        
        node_tmp = node
                
        store = set()
                
        while True:
            
            for key,value in cache.items():
                
                if value:
                    
                    if value.val < tmp:
                        
                        tmp = value.val
                        
                        index = key
                        
                else:
                    
                    val_val-=1
                    
                    store.add(key)
                    
            for k in store:
                
                del cache[k]
                
            store = set()
                    
            if val_val == 0:
                
                break
                        
            tmp = float('inf')
            
            node_tmp.next = ListNode(cache[index].val)
            
            node_tmp = node_tmp.next
            
            cache[index] = cache[index].next            
            
        return node.next
