class LinkedNode:
    
    def __init__(self,page):
        
        self.page = page
        self.next = None
        self.prev = None

class BrowserHistory:

    def __init__(self, homepage: str):
        
        self.allPage = LinkedNode(homepage)
        
        self.curPage = self.allPage
        
    def visit(self, url: str) -> None:
        
        new_page = LinkedNode(url)
        
        new_page.prev = self.curPage
        
        self.curPage.next = new_page
        
        self.curPage = new_page

    def back(self, steps: int) -> str:
        
        while steps != 0 and self.curPage.prev:
            
            self.curPage = self.curPage.prev
            
            steps-=1
        
        return self.curPage.page

    def forward(self, steps: int) -> str:
        
        while steps != 0 and self.curPage.next:
            
            self.curPage = self.curPage.next
            
            steps-=1
            
        return self.curPage.page
        
# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)
