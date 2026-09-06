class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long total = 0;
        for(int i : nums) total += i;
        long sum = 0;
        int i = 0;
        int j = 0;
        int res =0;
        while(j < n+n/2-1){
            sum += nums[j%n];
            if(j-i+1== n/2){
                if(total-sum < sum) res++;
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return res;
    }
}