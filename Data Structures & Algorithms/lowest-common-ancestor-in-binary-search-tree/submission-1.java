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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> stackP = new LinkedList<>();
        Queue<TreeNode> stackQ = new LinkedList<>();
        stackP.add(root);
        stackQ.add(root);
        if(p.val < root.val)
            findAncestor(root.left, p, stackP);
        else if(root.val < p.val)
            findAncestor(root.right, p, stackP);

        if(q.val < root.val)
            findAncestor(root.left, q, stackQ);
        else if(root.val < q.val)
            findAncestor(root.right, q, stackQ);
        
        TreeNode ancestorP = null;
        while(!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode ancP = stackP.poll();
            TreeNode ancQ = stackQ.poll();
            if(ancP.val == ancQ.val) {
                ancestorP = ancP;
            }
            else
                return ancestorP;
        }
        return ancestorP;

    }

    public void findAncestor(TreeNode root, TreeNode p, Queue<TreeNode> stackP) {
        if(null == root)
            return;
        else if(root.val == p.val) {
            stackP.add(root);
            return;
        }
        else if(root.val < p.val) {
            stackP.add(root);
            findAncestor(root.right, p, stackP);
        }
        else {
            stackP.add(root);
            findAncestor(root.left, p, stackP);
        }
    }
}
