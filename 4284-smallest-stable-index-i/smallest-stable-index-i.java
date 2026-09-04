class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minE = new int[n];
        minE[n-1] = nums[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            minE[i] = Math.min(minE[i+1] , nums[i]);
        }
        int mx = nums[0];
        for(int i = 0 ; i<n; i++){
            mx = Math.max(mx , nums[i]);
            if( (mx - minE[i]) <= k){
                return i;
            }
        }
        return -1;
    }
}