/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode each;
        
        int index = 0;
        
        ListNode[] output = new ListNode[k];
        
        int count = 0;
        
        ListNode tmp = head;
        
        while (tmp != null){
            
            count+=1;
            
            tmp = tmp.next;
            
        }
        
        int num = count / k;
        
        int rem = count % k;
        
        tmp = head;
        
        while (k > 0) {
            
            each = new ListNode();
            
            ListNode each_tmp = each;
            
            int cur = num;
            
            ListNode sec = new ListNode();
            
            while (cur != 0) {
                
                if (tmp == null) {
                    
                    break;
                    
                }
                
                each_tmp.next = tmp;
                
                sec = tmp;
                
                tmp = tmp.next;
                
                each_tmp = each_tmp.next;
                
                cur-=1;
                
            }
            
            if (rem > 0) {
                                
                each_tmp.next = tmp;
                
                rem-=1;
                
                sec = tmp;
                
                tmp = tmp.next;
                
                each_tmp = each_tmp.next;
                
            }
            
            sec.next = null;
                        
            output[index] = each.next;
            
            index+=1;
            
            k-=1;
            
        }
        
        return output;
    }
}
