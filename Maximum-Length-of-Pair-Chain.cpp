class Solution {
    
private:
    static bool compare(const std::vector<int>& a, const std::vector<int>& b){
        
        if (a[1] == b[1]) {
            
            return a[0] > b[0];
        }
        
        return a[1] < b[1];
    }
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        std::sort(pairs.begin(), pairs.end(), compare);
        
        int tmp = 1;
        
        int cur_min = pairs[0][1];
        
        for (int i {1}; i < pairs.size(); i++) {
            
            if (cur_min < pairs[i][0]) {
                
                tmp +=1;
                
                cur_min = pairs[i][1];
                
            }
            
        }
        
        return tmp;
        
    }
};
