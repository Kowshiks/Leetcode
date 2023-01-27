class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        output = float('inf')
        
        station = {}
        cache = {}
        
        for each in flights:
            
            if each[0] not in station.keys():
                
                station[each[0]] = []
                station[each[0]].append((each[1],each[2]))
            
            else:
                
                station[each[0]].append((each[1],each[2]))
        
        if src not in station.keys():
            
            return -1
        
        visited = set()
        fringe = collections.deque()
        visited.add(src)
        fringe.append((src,0,-1,visited))
        
        while fringe:
            
            tmp = True
            node,dist,stops,visit = fringe.popleft()
            visit.add(node)
            
            if node not in cache.keys():
                
                cache[node] = dist
            
            else:
                
                if cache[node] < dist:
                    
                    tmp = False
                
                else:
                    
                    cache[node] = dist
                
            if tmp:
            
                if stops == k:

                    if node == dst:

                        output = min(output,dist)

                elif dist > output:

                    continue

                elif node == dst:

                    output = min(output,dist)


                else:

                    if node in station.keys():

                        for j in station[node]:

                            cur_visit = visit.copy()

                            if j[0] not in cur_visit:

                                cur_visit.add(j[0])
                                fringe.append((j[0],dist+j[1],stops+1,cur_visit))
        
        if output != float('inf'):
        
            return output
        
        else:
            
            return -1
