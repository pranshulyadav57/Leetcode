class Solution {
    int n;
    int m;
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new Integer[n][m];
        return fxn(0,0,word1,word2);
    }
    int fxn(int i , int j , String s1 , String s2){
        if(i == n && j == m) return 0;
        if(i == n) return (m-j);
        if(j == m) return (n-i);
        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = fxn(i+1 , j +1 , s1 , s2);
        }
        else{
            int l = fxn(i+1 , j , s1 , s2);
            int r = fxn(i , j+1 , s1 , s2);
            return dp[i][j] = 1 + Math.min(l , r);
        }
    }
}