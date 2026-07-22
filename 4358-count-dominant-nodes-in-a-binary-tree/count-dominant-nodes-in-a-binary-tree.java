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
    int count = 0;
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return count;
    }
    int dfs(TreeNode root){
        if(root.left == null && root.right == null){
            count++;
            return root.val;
        }
        int left = 0;
        int right = 0;
        if(root.left != null) left = dfs(root.left);
        if(root.right != null) right = dfs(root.right);
        int mx = Math.max(left , right);
        if(root.val >= mx) count++;
        return Math.max(mx , root.val);
    }
}