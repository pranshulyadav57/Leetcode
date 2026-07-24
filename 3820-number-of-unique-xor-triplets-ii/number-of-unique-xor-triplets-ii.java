class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int mx = 2048;
        boolean[] pair = new boolean[mx];
        boolean[] triplet = new boolean[mx];
        for(int i = 0 ; i<nums.length; i++){
            for(int j = 0 ; j < nums.length; j++){
                pair[nums[i] ^ nums[j]] = true;
            }
        }
        for(int i = 0 ; i < mx; i++){
            if(!pair[i]) continue;
            for(int n : nums){
                triplet[n ^ i] = true;
            }
        }
        int count = 0;
        for(boolean i : triplet){
            if(i) count++;
        }
        return count;
    }
}