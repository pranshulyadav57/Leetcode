class Solution {
    int n;
    Integer[][] dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new Integer[n][2*n+1];
        for(int i = n-2; i>=0; i--){
            piles[i] += piles[i+1];
        }
        return fxn(0,1,piles);
    }
    int fxn(int i , int m , int[] piles){
        if (i + m * 2 >= n)
            return piles[i];
        if(dp[i][m] != null) return dp[i][m];
        int res = Integer.MAX_VALUE;
        for(int X = 1 ; X <= 2 *m; X++){
            res = Math.min(res , fxn(i+X , Math.max(m,X) , piles));
        }
        int val = piles[i] - res;
        return dp[i][m] = val;
    }
}