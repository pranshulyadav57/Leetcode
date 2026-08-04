class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int valid = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i ++){
            int x = 0;
            int y = 0;
            for(int j = i ; j < n ; j++){
                if(nums[j] % 2 != 0) y++;
                else x++;
                if(y > 0 && (long) x*b <= (long) a*y) valid++;
            }
        }
        return valid;
    }
}