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
    TreeNode newRoot;
    public TreeNode searchBST(TreeNode root, int val) {
        boolean res = dfs(root , val);
        return res ? newRoot : null;
    }
    boolean dfs(TreeNode root , int val){
        if(root == null) return false;
        if(root.val == val){
            newRoot = root;
            return true;
        }
        boolean l = false;
        boolean f = false;
        if(root.left != null) l = dfs(root.left , val);
        if(root.right != null) f = dfs(root.right, val);
        return l || f;
    }
}