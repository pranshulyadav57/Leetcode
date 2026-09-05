class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxE = new int[n];
        int[] minE = new int[n];
        maxE[0] = nums[0];
        minE[n-1] = nums[n-1];
        for(int i = 1 ; i < n ; i++){
            maxE[i] = Math.max(maxE[i-1] , nums[i]);
        }
        for(int j = n-2; j >= 0 ; j--){
            minE[j] = Math.min(minE[j+1] , nums[j]);
        }
        for(int i = 0 ; i < n ; i++){
            if(maxE[i] - minE[i] <= k) return i;
        }
        return -1;
    }
}