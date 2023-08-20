class TimeMap:

    def __init__(self):
        
        self.timeStampcache = []
        
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        
        if key not in self.store.keys():
            
            self.store[key] = [(timestamp,value)]
        
        else:
        
            self.store[key].append((timestamp,value))
        
    def get(self, key: str, timestamp: int) -> str:
        
        if key not in self.store.keys():
            
            return ""
        
        timeStampcache = self.store[key]
        
        l = 0
        r = len(timeStampcache) - 1
        
        while l <= r:
            
            mid = (l+r)//2
            
            if timeStampcache[mid][0] == timestamp:
                
                break
            
            elif timeStampcache[mid][0] < timestamp:
                
                l = mid+1
            
            elif timeStampcache[mid][0] > timestamp:
                
                r = mid-1
                
        if timeStampcache[mid][0] > timestamp:
            
            if mid == 0:
                
                return ""
            
            mid-=1
            
        return self.store[key][mid][1]
            
# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
