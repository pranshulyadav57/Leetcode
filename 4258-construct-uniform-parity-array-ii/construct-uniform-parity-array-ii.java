class Solution {
    public boolean uniformArray(int[] nums1) {
        int even = 0;
        int odd = 0;
        int n = nums1.length;
        Arrays.sort(nums1);
        boolean o = false;
        for(int i = 0 ; i < n ; i++){
            if(nums1[i] % 2== 0){
                even++;
                if(o) odd++;
            }
            else{
                odd++;
                if(o) even++; 
                o = true;
            }
        }
        if(odd == n || even == n) return true;
        return false;
    }
}