class Solution {
    int bs(int[] arr , int target , int idx){
        int left = idx;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int res = n+1;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        if(pre[0] == x || suf[n-1] == x) return 1;
        for(int i = 1 ; i < n ; i++){
            pre[i] = pre[i-1] + nums[i];
            if(pre[i] == x) res = Math.min(res , i+1);
        }
        for(int i = n-2 ; i>=0 ; i--) {
            suf[i] = suf[i+1] + nums[i];
            if(suf[i] == x) res = Math.min(res , n -i);
        }    
        for(int i = 0 ; i < n ; i++){
            int idx = bs(suf , x - pre[i] , i+1);
            if(idx != -1){
                res = Math.min(res , (i+1) + (n-idx));
            }
        }
        return (res == n+1) ? -1 : res;
    }
}