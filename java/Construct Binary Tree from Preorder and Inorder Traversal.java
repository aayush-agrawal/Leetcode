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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = IntStream.range(0,inorder.length)
                                       .boxed()
                                       .collect(Collectors.toMap(i->inorder[i], i->i));
            return construct(0, preorder.length-1, preorder, map, new AtomicInteger());
    }
    
    public TreeNode  construct(int start, int end, int[] preorder, Map<Integer, Integer> inorder, AtomicInteger pIndex) {
        if(start > end)
            return null;
        
        TreeNode node = new TreeNode(preorder[pIndex.getAndIncrement()]);
        int index = inorder.get(node.val);
        
        node.left = construct(start, index-1, preorder, inorder, pIndex);
        node.right = construct(index+1, end, preorder, inorder, pIndex);
        
        return node;
    }
}