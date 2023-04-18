class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        cache = costs[0]

        for i in range(1, len(costs)):

            for j in range(len(costs[i])):

                ans = float("inf")

                for k in range(len(cache)):

                    if j!=k:

                        ans = min(ans,costs[i][j]+cache[k])

                costs[i][j] = ans

            cache = costs[i]

        return min(cache)
