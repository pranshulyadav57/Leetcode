class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return fxn(0,0,s,t);
    }
    int fxn(int i , int j , String s , String t){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int in = 0;
        int ex = 0;
        if(s.charAt(i) == t.charAt(j)){
            in = fxn(i+1,j+1,s,t);
        }
        ex = fxn(i+1,j,s,t);
        return dp[i][j] = in+ex;
    }
}