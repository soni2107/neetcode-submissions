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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while(!stack.isEmpty())
                list.add(stack.poll());

            List<Integer> level = new ArrayList<>();
            for(TreeNode node : list) {
                if(null == node)
                    continue;
                stack.add(node.left);
                stack.add(node.right);
                level.add(node.val);
            }
            if(!level.isEmpty())
                result.add(level);
        }
        return result;
    }
}
