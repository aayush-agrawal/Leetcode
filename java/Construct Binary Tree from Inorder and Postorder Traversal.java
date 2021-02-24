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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
             Map<Integer, Integer> map = IntStream.range(0,inorder.length)
                                       .boxed()
                                       .collect(Collectors.toMap(i->inorder[i], i->i));
            return construct(0, postorder.length-1, postorder, map, new AtomicInteger(postorder.length-1));   
    }
    
    public TreeNode  construct(int start, int end, int[] postorder, Map<Integer, Integer> inorder, AtomicInteger pIndex)     {
        if(start > end)
            return null;
        
        TreeNode node = new TreeNode(postorder[pIndex.getAndDecrement()]);
        int index = inorder.get(node.val);

        node.right = construct(index+1, end, postorder, inorder, pIndex);
        node.left = construct(start, index-1, postorder, inorder, pIndex);

        
        return node;
    }
}