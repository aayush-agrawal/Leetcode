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
class Solution {
     public int findBottomLeftValue(TreeNode root) {
         Helper helper = new Helper();
        findBottomLeftValue(root, 1, helper);
         return helper.value;
    }
    public void findBottomLeftValue(TreeNode root, int depth, Helper helper) {
        if (helper.depth<depth) {
            helper.value=root.val;helper.depth=depth;
        }
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, helper);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, helper);
    }
    
    class Helper {
        public int value;
        public int depth;
    }
}