/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Func {

    TreeNode head;
    int index;

    Func(){}

    public TreeNode getHead(){
        return head;
    }

    public int getIndex(){
        return index;
    }

}

class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null){

            return output;
        }

        HashMap<Integer,List<Integer>> cache = new HashMap<>();

        ArrayList<Func> fringe = new ArrayList<>();

        Func obj = new Func();

        obj.head = root;

        obj.index = 0;

        fringe.add(obj);

        int min_val = 0;

        while (!fringe.isEmpty()) {

            Func cur = fringe.remove(0);

            TreeNode node = cur.getHead();
            int val = cur.getIndex();

            if (!cache.containsKey(val)){

                List<Integer> each = new ArrayList<>();

                each.add(node.val);

                cache.put(val,each);
            }

            else {

                cache.get(val).add(node.val);

            }

            if (node.left != null){

                Func cur_left = new Func();

                cur_left.head = node.left;

                cur_left.index = val-1;

                min_val = Math.min(min_val,val-1);

                fringe.add(cur_left);

            }

            if (node.right != null){

                Func cur_right = new Func();

                cur_right.head = node.right;

                cur_right.index = val+1;

                fringe.add(cur_right);

            }

        }

        while (cache.containsKey(min_val)){

            output.add(cache.get(min_val));

            min_val+=1;

        }

        return output;

    }
}
