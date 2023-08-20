class UndergroundSystem:

    def __init__(self):
        
        self.stationData = {}
        
        self.customerData = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        
        self.customerData[id] = [stationName, t]    
        
    def checkOut(self, id: int, stationName: str, t: int) -> None:
        
        if self.customerData[id][0]+"-"+stationName not in self.stationData.keys():
            
            self.stationData[self.customerData[id][0]+"-"+stationName] = [1,t-self.customerData[id][1]]
            
        else:
            
            self.stationData[self.customerData[id][0]+"-"+stationName][0]+=1
            self.stationData[self.customerData[id][0]+"-"+stationName][1] += (t-self.customerData[id][1])

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        
        return self.stationData[startStation+"-"+endStation][1] / self.stationData[startStation+"-"+endStation][0]

# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)
