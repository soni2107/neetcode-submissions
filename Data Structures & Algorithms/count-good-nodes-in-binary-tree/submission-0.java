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
    public int goodNodes(TreeNode root) {
        int[] array = new int[1];
        array[0] = 0;
        findGoodNode(root, array, Integer.MIN_VALUE);
        return array[0];
    }

    public void findGoodNode(TreeNode root, int[] array, int maxVal) {
        if(null == root)
            return;

        if(root.val >= maxVal)
            array[0] = array[0] + 1;
        maxVal = Math.max(root.val, maxVal);

        findGoodNode(root.left, array, maxVal);
        findGoodNode(root.right, array, maxVal);
    }
}
