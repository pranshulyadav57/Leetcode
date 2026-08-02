class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return fxn(0 , 0 , piles) > 0;
    }
    int fxn(int i , int j , int[] piles){
        if(i == j) return piles[i];
        if(dp[i][j] != null) return dp[i][j];
        int left = piles[i] - fxn(i+1 , j , piles);
        int right = piles[j] - fxn(i , j - 1 , piles);
        return dp[i][j] =  Math.max(left , right);
    }
}