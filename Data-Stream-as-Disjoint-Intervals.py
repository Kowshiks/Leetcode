class SummaryRanges:

    def __init__(self):
        
        self.output = []
        

    def addNum(self, value: int) -> None:
        
        tmp = True
        
        if not self.output:
            
            self.output.append([value,value])
        
        else:
            
            for i in range(len(self.output)):
                
                if value == self.output[i][0]-1:
                    
                    self.output[i][0] = value
                    
                    tmp = False
                
                elif value == self.output[i][1]+1:
                                        
                    self.output[i][1] = value
                    
                    tmp = False
                
                elif value >= self.output[i][0] and value <= self.output[i][1]:
                    
                    tmp = False
                
            
            if tmp:
                
                cur_output = [[value,value]]
                
                if value < self.output[0][0]:
                    
                    self.output = cur_output + self.output
                
                elif value > self.output[-1][1]:
                                        
                    self.output = self.output + cur_output
                    
                else:
                    
                    for i in range(len(self.output)-1):
                        
                        if value > self.output[i][1] and value < self.output[i+1][0]:
                            
                            self.output = self.output[:i+1] + cur_output + self.output[i+1:]
                            
                            break
                            
            else:
                
                for i in range(len(self.output)-1):
                    
                    if self.output[i][1] == self.output[i+1][0]:
                                                
                        if len(self.output)-2 > i:
                            
                            self.output = self.output[:i] + [[self.output[i][0],self.output[i+1][1]]] + self.output[i+2:]
                                 
                        else:
                            
                            self.output = self.output[:i] + [[self.output[i][0],self.output[i+1][1]]]
                        
                        break
            
    def getIntervals(self) -> List[List[int]]:
        
        return self.output


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()
