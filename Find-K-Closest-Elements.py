# Binary Search Solution

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        l = 0
        r = len(arr)-1
        tmp = float('inf')
        index = 0
        
        while l<=r:
            
            mid = (l+r)//2      
            
            if arr[mid] == x:
                index = mid              
                break
            
            elif arr[mid] > x:  
                r = mid - 1
            
            else:
                l = mid + 1
                                
            if abs(x-arr[mid]) <= tmp:
                
                if abs(x-arr[mid]) == tmp:
                    index = min(index,mid)
                    
                else:        
                    tmp = abs(x-arr[mid])
                    index = mid
                
        ans = [arr[index]]
        k-=1
        l = index-1
        r = index+1
            
        while k!=0:
            
            if l >= 0 and r < len(arr):
                
                if abs(x-arr[l]) <= abs(x-arr[r]):
                    ans.append(arr[l])
                    l-=1
                
                else:
                    ans.append(arr[r])
                    r+=1
                    
            elif l >= 0:
                ans.append(arr[l])
                l-=1
            
            else:
                ans.append(arr[r])
                r+=1
                
            k-=1
            
        ans.sort()
        return ans
        
