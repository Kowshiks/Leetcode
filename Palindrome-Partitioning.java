class Solution {
    
    String s;
    
    List<List<String>> output = new ArrayList<>();
    
    public boolean valid(String s1){
        
        StringBuilder s2  = new StringBuilder(s1);
        
        s2 = s2.reverse();
        
        return s1.equals(s2.toString());
        
    }
    
    public void rec(String node,List<String> visit){
        
        if (node.isEmpty()){
            
            output.add(visit);
            
            return;
        }
        
        for(int i = 0; i< node.length(); i++){
            
            String sub = node.substring(0,i+1);
            
            if (valid(sub)){
                
                List<String> cutTmp = new ArrayList<>(visit);
                
                cutTmp.add(sub);
                
                rec(node.substring(i+1,node.length()),cutTmp);
                
            }
            
        }
        
    }
        
    public List<List<String>> partition(String s) {
        
        this.s = s;
        
        List<String> cur = new ArrayList<>();
        
        rec(s,cur);
        
        return output;
        
        
    }
}
