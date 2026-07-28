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
    int[] freq = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root);
    }
    int dfs(TreeNode root){
        freq[root.val]++;
        if(root.left == null && root.right == null){
            int cnt = 0;
            for(int i = 1 ; i < 10; i++){
                if(freq[i] % 2 != 0) cnt++;
            }
            freq[root.val]--;
            return cnt > 1 ? 0 : 1;
        }
        int left = 0;
        if(root.left != null) left = dfs(root.left);
        int right = 0;
        if(root.right != null) right = dfs(root.right);
        freq[root.val]--;
        return left + right;
    }
}