class Solution {
    public int splitArray(int[] nums, int k) {
        int left = nums[0];
        int right = 0;
        for(int i : nums){
            left = Math.max(i , left);
            right += i;
        }
        int ans = right;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(nums , k , mid)){
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    boolean check(int[] arr , int k , int maxSum){
        int cnt = 1;
        int sum = 0;
        for(int n : arr){
            if(sum + n > maxSum){
                cnt++;
                sum = n;
            }
            else sum += n;
        }
        return cnt <= k;
    }
}