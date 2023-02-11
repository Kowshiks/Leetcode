class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        
        
        red = {}
        
        blue = {}
        
        for i in redEdges:
            
            if i[0] not in red.keys():
                
                red[i[0]] = [i[1]]
            
            else:
                
                red[i[0]].append(i[1])
        
        for j in blueEdges:
            
            if j[0] not in blue.keys():
                
                blue[j[0]] = [j[1]]
            
            else:
                
                blue[j[0]].append(j[1])
                
        
        output = [0]
        
        fringe = collections.deque()
        
        fringe.append((0,0,None))
        
        visit = set()
        
        visit.add((0,None))
                
        output = [-1]*n
       
                                
        while fringe:
            
            node,dist,flag = fringe.popleft()

            if output[node] == -1:

                output[node] = dist

                
            if flag != "RED":

                if node in red.keys():

                    for j in red[node]:

                        if (j,"RED") not in visit:

                            visit.add((j,"RED"))

                            fringe.append((j,dist+1,"RED"))

            if flag != "BLUE":

                    if node in blue.keys():

                        for j in blue[node]:

                            if (j,"BLUE") not in visit:

                                visit.add((j,"BLUE"))

                                fringe.append((j,dist+1,"BLUE"))

        
        return output
