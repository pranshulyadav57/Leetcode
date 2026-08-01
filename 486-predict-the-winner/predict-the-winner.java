class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int result = fxn(0,n-1,nums);
        return result>= 0 ? true:false;
    }
    public static int fxn(int i , int j , int[] nums){
        if(i==j) return nums[i];
        int left = nums[i] - fxn(i+1, j , nums);
        int right = nums[j] - fxn(i, j-1 , nums);
        return Math.max(left, right);
    }
}