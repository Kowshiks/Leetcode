class Solution:
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:

        logs.sort(key = lambda x:x[0])

        cache = {}

        for i in range(len(logs)):

            time  = logs[i][0]
            first = logs[i][1]
            second = logs[i][2]

            if first not in cache.keys():

                cache[first] = set()

            cache[first].add(second)

            if second not in cache.keys():

                cache[second] = set()

            cache[second].add(first)
 
            fringe = [first]

            visited = set()

            while fringe:

                cur = fringe.pop()

                visited.add(cur)

                for j in cache[cur]:

                    if j not in visited:

                        fringe.append(j) 

                        visited.add(j)

            if len(visited) == n:

                return time

        return -1
