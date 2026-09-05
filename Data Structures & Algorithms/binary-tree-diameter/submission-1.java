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
    public int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //Max Diameter will be sum of max length of left + length of right
        calculateDiameter(root);
        return diameter;
    }

    public int calculateDiameter(TreeNode root) {
        if(null == root)
            return 0;

        int leftLength = calculateDiameter(root.left);
        int rightLength = calculateDiameter(root.right);

        diameter = Math.max(diameter, leftLength + rightLength);
        return Math.max(leftLength, rightLength) + 1;
    }
}
