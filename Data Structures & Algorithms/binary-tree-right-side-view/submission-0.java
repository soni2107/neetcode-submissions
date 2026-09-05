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
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            while(!stack.isEmpty())
                temp.add(stack.poll());
            result.add(temp.get(temp.size() - 1).val);
            for(TreeNode node : temp) {
                if(null != node.left)
                    stack.add(node.left);
                if(null != node.right)
                    stack.add(node.right);
            }
        }

        return result;
    }
}
