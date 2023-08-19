class Twitter:

    def __init__(self):
        
        self.userPost = {}
        
        self.tweetOrder = -1
        
        self.followers = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        
        if userId not in self.userPost.keys():
            
            self.userPost[userId] = [(self.tweetOrder,tweetId)]
            
        else:
            
            self.userPost[userId].append((self.tweetOrder,tweetId))
            
        self.tweetOrder -= 1
        
    def getNewsFeed(self, userId: int) -> List[int]:
        
        heap = []
        
        index = 0
        
        if userId in self.userPost.keys():
        
            for i in range(len(self.userPost[userId])-1,-1,-1):

                if index == 10:

                    break

                heapq.heappush(heap,self.userPost[userId][i])

                index+=1
            
        if userId in self.followers.keys():
            
            for i in self.followers[userId]:
                
                if i in self.userPost.keys():
                    
                    index = 0

                    for j in range(len(self.userPost[i])-1,-1,-1):

                        if index == 10:

                            break

                        heapq.heappush(heap,self.userPost[i][j])

                        index+=1
        
        output = []
        
        index = 0
        
        while index!=10 and heap:
            
            val = heapq.heappop(heap)
            
            output.append(val[1])
            
            index+=1
        
        return output

    def follow(self, followerId: int, followeeId: int) -> None:
        
        if followerId not in self.followers.keys():
            
            self.followers[followerId] = set()
            
            self.followers[followerId].add(followeeId)
            
        else:
            
            self.followers[followerId].add(followeeId)
            
    def unfollow(self, followerId: int, followeeId: int) -> None:
        
        if followerId in self.followers.keys():
        
            self.followers[followerId].remove(followeeId)
        
# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
