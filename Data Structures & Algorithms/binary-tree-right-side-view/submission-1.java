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
    public List<Integer> rightSideView(TreeNode root) {
        if(null == root)
            return new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.offer(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                if(i ==0)
                    result.add(node.val);
                if(null != node.right)
                    stack.offer(node.right);
                if(null != node.left)
                    stack.offer(node.left);
            }
        }

        return result;
    }
}
