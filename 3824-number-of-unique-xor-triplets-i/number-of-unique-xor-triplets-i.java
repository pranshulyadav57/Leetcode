class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int msk = 0;
        for(int i : nums){
            msk |= i;
        }
        return msk +1;
    }
}