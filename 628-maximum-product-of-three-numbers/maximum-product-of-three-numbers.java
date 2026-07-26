class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int product = nums[n-1] * nums[n-2] * nums[n-3];
        product = Math.max(product , nums[0] * nums[1] * nums[n-1]);
        return product;
    }
}