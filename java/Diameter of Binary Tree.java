import java.util.concurrent.atomic.AtomicInteger; 
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
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger();  
        diameter(root, diameter);
        return diameter.get();
    }
    
    public int diameter(TreeNode root, AtomicInteger diameter) {
        if(root == null)
            return 0;
        
        int left_height = diameter(root.left, diameter);
        int right_height = diameter(root.right, diameter);
        int current_diameter = left_height + right_height;
        diameter.set(Math.max(diameter.get(), current_diameter));
        
        return Math.max(left_height, right_height) + 1;
    }

}