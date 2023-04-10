class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        tmp = False
        
        output = []
        
        for i in range(len(asteroids)):
                        
            if asteroids[i] > 0:
                                
                tmp = True
                
                output.append(asteroids[i])
                
            if not output or output[-1] < 0:
                                
                tmp = False
                
                output.append(asteroids[i])
                
            elif tmp and asteroids[i] < 0:
                                
                if output[-1] > 0:
                    
                    while True:
                        
                        if not output or output[-1] < 0:
                            
                            output.append(asteroids[i])
                            
                            break
                    
                        elif abs(asteroids[i]) > output[-1]:

                            output.pop()
                            
                        elif abs(asteroids[i]) == output[-1]:

                            output.pop()
                            
                            break
                            
                        elif abs(asteroids[i]) < output[-1]:

                            break
                            
            elif asteroids[i] < 0:
                
                output.append(asteroids[i])
                
        return output
