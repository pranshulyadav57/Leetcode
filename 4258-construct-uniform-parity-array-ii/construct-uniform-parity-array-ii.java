class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        for(int i : nums1){
            mn = Math.min(mn , i);
        }
        if(mn%2 !=0) return true;
        for(int i : nums1){
            if(i%2 !=0) return false;
        }
        return true;
    }
}