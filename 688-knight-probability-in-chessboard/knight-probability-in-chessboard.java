class Solution {
    int[][] dir = {{1,2} , {-1,2} , {1,-2} , {-1,-2} , {2,1} , {-2,1} , {-2,-1} , {2,-1}};
    Double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new Double[n][n][k+1];

        return fxn(row , column , k , n);
    }
    double fxn(int r , int c , int k , int n){
        if(r < 0 || c < 0 || r >= n || c >= n) return 0.00;
        if(k == 0) return 1.00;
        if(dp[r][c][k] != null) return dp[r][c][k];
        double prob = 0.00;
        for(int i = 0 ; i < 8 ; i++){
            prob += fxn(r+dir[i][0] , c + dir[i][1] , k - 1, n)/8.00;
        }
        return dp[r][c][k] = prob;
    }
}