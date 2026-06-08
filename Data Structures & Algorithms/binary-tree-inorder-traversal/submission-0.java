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
    private List<Integer> solution;
    public List<Integer> inorderTraversal(TreeNode root) {
        
        solution = new ArrayList<Integer>();
        inOrder(root);
        return solution;
    }

    public void inOrder(TreeNode current) {
        if(current == null) return;

        inOrder(current.left);
        solution.add(current.val);
        inOrder(current.right);
    }
}