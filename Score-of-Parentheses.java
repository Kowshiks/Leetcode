class Solution {
    public int scoreOfParentheses(String s) {
        
        ArrayList<Integer> stack = new ArrayList<>();
        
        int output = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            if (s.charAt(i) == '(') {
                
                stack.add(0);
                
            }
            
            else  {
                
                if (stack.get(stack.size()-1) == 0) {
                    
                    stack.remove(stack.size()-1);

                    stack.add(1);
                    
                }
                
                else {
                
                    int cur = 0;

                    int index = stack.size()-1;

                    while (stack.get(index) != 0) {

                        cur += stack.remove(index);

                        index-=1;

                    }

                    stack.remove(index);

                    stack.add(2*cur);
                          
                }
                
            }
            
        }
        
        for(int each:stack){
            
            output+=each;
        }
        
        return output;
        
    }
}
