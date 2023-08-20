class HitCounter:

    def __init__(self):

        self.cache = []
        
    def hit(self, timestamp: int) -> None:

        self.cache.append(timestamp)
        
    def getHits(self, timestamp: int) -> int:

        l = 0
        r = len(self.cache)-1

        val = max(0,timestamp - 300 + 1)

        print(val)

        if not self.cache:

            return 0

        if val > self.cache[-1]:

            return 0

        while l <= r:

            mid = (l+r)//2

            if self.cache[mid] >= val:

                if self.cache[mid] == val:

                    break

                r = mid-1

            elif self.cache[mid] < val:

                l = mid+1

        while self.cache[mid] < val:

            mid+=1
        
        while mid > 0 and self.cache[mid] == self.cache[mid-1]:

            mid -=1

        return len(self.cache) - mid 

# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)
