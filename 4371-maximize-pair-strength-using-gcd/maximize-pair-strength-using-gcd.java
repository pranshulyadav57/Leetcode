class Solution {
    public long maxPairStrength(int[] nums) {
        long res = 0;
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i + 1 ; j < nums.length; j++){
                int g = gcd(nums[i] , nums[j]);
                long d =(long) g * g;
                long p = (long) nums[i] * nums[j];
                res = Math.max(res , p / d);
            }
        }
        return res;
    }
    int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b , a % b);
    }
}