class Solution {
    
    public int evalRPN(String[] tokens) {
        
        HashSet<String> method = new HashSet<>();
        
        method.add("*");
        method.add("/");
        method.add("+");
        method.add("-");
        
        ArrayList<Integer> stack = new ArrayList<>();
        
        for(int i=0 ; i < tokens.length; i++){
            
            if (method.contains(tokens[i])) {
                
                int l2 = stack.remove(stack.size()-1);
                
                int l1 = stack.remove(stack.size()-1);
                
                
                if (tokens[i].equals("+")){
                    
                    stack.add(l1+l2);
                    
                }
                
                else if (tokens[i].equals("-")){
                    
                    stack.add(l1-l2);
                }
                
                else if (tokens[i].equals("*")){
                    
                    stack.add(l1*l2);
                }
                
                else {
                    
                    stack.add(l1/l2);
                }
                
            }
            
            else {
                
                stack.add(Integer.parseInt(tokens[i]));
            }
                        
        }
        
        return stack.get(0);
        
    }
}
