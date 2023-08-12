import heapq

class StockPrice:

    def __init__(self):
        
        self.cache = {}
        
        self.min_heap = []
        self.max_heap = []
        
        self.time_max = 0
        
    def update(self, timestamp: int, price: int) -> None:
        
        self.time_max = max(self.time_max,timestamp)
                
        self.cache[timestamp] = price
            
        heapq.heappush(self.min_heap,(price,timestamp))  

        heapq.heappush(self.max_heap,(-price,timestamp))
            

    def current(self) -> int:
        
        return self.cache[self.time_max]
    
    def maximum(self) -> int:
        
        cur_price,cur_time = heapq.heappop(self.max_heap)
        
        while -cur_price != self.cache[cur_time]:
            
            cur_price,cur_time = heapq.heappop(self.max_heap)
            
        
        heapq.heappush(self.max_heap,(cur_price,cur_time))
        
        return -cur_price

    def minimum(self) -> int:
        
        cur_price,cur_time = heapq.heappop(self.min_heap)
        
        while cur_price != self.cache[cur_time]:
            
            cur_price,cur_time = heapq.heappop(self.min_heap)
            
        
        heapq.heappush(self.min_heap,(cur_price,cur_time))
        
        return cur_price

# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()
