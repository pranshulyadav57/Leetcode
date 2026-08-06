class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int n = nums.length;
        int j = n-1;
        while(i < j){
            if(nums[i] % 2 == 0) i++;
            if(nums[j] % 2 != 0) j--;
            if((i < n && nums[i] % 2 != 0 && j >i && nums[j] % 2 == 0)){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
}