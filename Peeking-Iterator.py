# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator:
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator:
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        
        self.node = iterator
        
        self.cache = 0
        
        self.tmp = False
        
        

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        
        if not self.tmp:
            
            self.tmp = True
            
            self.cache = self.node.next()
        
        return self.cache
        

    def next(self):
        """
        :rtype: int
        """
        
        if not self.tmp:
            
            return self.node.next()
        
        else:
            
            self.tmp = False
            
            return self.cache
        

    def hasNext(self):
        """
        :rtype: bool
        """
        
        if not self.tmp:
    
            return self.node.hasNext()
        
        else:
            
            return True
        

# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
