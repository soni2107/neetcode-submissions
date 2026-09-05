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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(null == root && null == subRoot)
            return true;
        else if(null == root || null == subRoot)
            return false;
        boolean isSubTree = false;
        if(root.val == subRoot.val)
            isSubTree = checkSubTree(root, subRoot);
        
        if(!isSubTree)
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
        return true;

    }

    public boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        if(null == root && null == subRoot)
            return true;
        else if(null == root || null == subRoot)
            return false;
        
        return (root.val == subRoot.val) && checkSubTree(root.left, subRoot.left)
            && checkSubTree(root.right, subRoot.right);
    }
}
