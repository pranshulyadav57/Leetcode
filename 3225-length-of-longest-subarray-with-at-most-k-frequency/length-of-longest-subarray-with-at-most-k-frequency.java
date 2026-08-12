class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> hp = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        int res = 0;
        while(j < n){
            hp.put(nums[j] , hp.getOrDefault(nums[j] , 0)+1);
            while(hp.get(nums[j]) >k){
                hp.put(nums[i] , hp.getOrDefault(nums[i] , 0) -1);
                if(hp.get(nums[i]) == 0) hp.remove(nums[i]);
                i++;
            }
            res  = Math.max(res , j-i+1);
            j++;
        }
        return res;
    }
}