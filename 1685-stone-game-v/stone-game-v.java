class Solution {
    int n;
    int[] pref;
    Integer[][] dp;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        pref = new int[n];
        pref[0] = stoneValue[0];
        dp = new Integer[n+1][n+1];
        for(int i = 1 ; i < n ; i++){
            pref[i] = pref[i-1]+stoneValue[i];
        }
        return fxn(0,n-1,stoneValue);
    }
    int fxn(int l , int r , int[] arr){
        if(l == r) return 0;
        if(dp[l][r] != null) return dp[l][r];
        int res = 0;
        for(int i = l; i <=r ; i++){
            int lSum = pref[i] -((l == 0) ? 0 : pref[l-1]);
            int rSum = pref[r] - pref[i];
            if(lSum < rSum){
                res = Math.max(res , lSum + fxn(l,i,arr));
            }
            else if(lSum > rSum){
                res = Math.max(res , rSum + fxn(i+1 , r, arr));
            }
            else{
                res = Math.max(res , Math.max(lSum + fxn(l,i,arr) , rSum+fxn(i+1,r,arr)));
            }
        }
        return dp[l][r] = res;
    }
}