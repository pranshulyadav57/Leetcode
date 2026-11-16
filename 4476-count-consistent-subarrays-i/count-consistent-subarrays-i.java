class Solution {
    public int countConsistent(int[] nums) {
        int cnt = 0;
        for(int i = 0 ; i < nums.length; i++){
            int min = nums[i];
            int bit = nums[i];
            for(int j = i ; j < nums.length; j++){
                min = Math.min(min , nums[j]);
                bit &= nums[j];
                if(bit == min) cnt++;
            }
        }
        return cnt;
    }
}