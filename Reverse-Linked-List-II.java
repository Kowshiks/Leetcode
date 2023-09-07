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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode tmp = head;
        
        int count = 1;
        
        ListNode start = new ListNode();
        
        start.next = head;
        
        ListNode end = null;
            
        
        ListNode last_node = new ListNode();
        
        while (tmp != null) {
            
            
            if ((left != 1) && (count == left-1)){
            
                start = tmp;
            
            }
            
            if (count == right+1) {
                
                end = tmp;
                
                break;
                
            }
            
            last_node = tmp;
            
            tmp = tmp.next;
            
            count+=1;
            
        }
        
        
        System.out.println(last_node.val);
        
        ListNode first_node = start.next;
                
        start.next = null;
        
        last_node.next = null;
        
        ListNode cur = null;
        
        tmp = first_node;
        
        ListNode cnt = tmp;
        
        while (tmp != null) {
            
            tmp = tmp.next;
            
            cnt.next = cur;
            
            cur = cnt;
            
            cnt = tmp;
            
        }
        
        start.next = cur;
        
        first_node.next = end;
        
        
        if (left == 1) {
            
            return cur;
            
        }
        
        return head;
        
    }
}
