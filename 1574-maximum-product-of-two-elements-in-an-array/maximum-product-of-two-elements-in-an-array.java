class Solution {
    public int maxProduct(int[] nums) {
        int mx1 = Math.max(nums[0] , nums[1]);
        int mx2 = Math.min(nums[0] , nums[1]);
        for(int i = 2 ; i < nums.length; i++){
            if(nums[i] >= mx1){
                mx2 = mx1;
                mx1 = nums[i];
            }else{
                mx2 = Math.max(mx2 , nums[i]);
            }
        }
        return (mx1-1) * (mx2-1);
    }
}