class Solution {
    public int longestSubsequence(int[] nums) {
        int countZero = 0;
        int xor = 0;
        int i = 0;
        while(i<nums.length){
            xor = xor ^ nums[i];
            if(nums[i] == 0){
                countZero++;
            }
            i++;
        }
        if(countZero == nums.length){
            return 0;
        }
        if(xor != 0){
            return nums.length;
        }
        else{
            return nums.length -1;
        }
    }
}