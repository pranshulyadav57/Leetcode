class Solution {
    boolean bs(int[] nums , int t){
        int left = 0;
        int right = nums.length-1;
        while(left <=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == t) return true;
            else if(nums[mid] < t) left = mid+1;
            else right = mid-1; 
        }
        return false;
    }
    public int missingInteger(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0]+1;
        int sum = nums[0];
        for(int i = 1 ; i < n ; i++){
            if(nums[i] != nums[i-1]+1) break;
            sum += nums[i];
        }
        Arrays.sort(nums);
        while(bs(nums, sum)){
            sum++;
        }
        return sum;
    }
}