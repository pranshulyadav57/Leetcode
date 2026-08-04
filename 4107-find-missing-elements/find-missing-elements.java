class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = nums[0];
        int r = nums[0];
        for(int i : nums){
            l = Math.min(l , i);
            r = Math.max(r , i);
            set.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = l ; i <=r; i++){
            if(!set.contains(i)) res.add(i);
        }
        return res;
    }
}