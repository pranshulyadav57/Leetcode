class Solution {
    public int countSpecialIntegers(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0 ; i <= 100; i++) l.add(new ArrayList<>());
        for(int i = 0 ; i < nums.length; i++){
            l.get(nums[i]).add(i);
        }
        int res = 0;
        for(int i = 0 ; i <= 100 ; i++){
            if(l.get(i).size() == 3){
                int j = l.get(i).get(0);
                int k = l.get(i).get(1);
                int m = l.get(i).get(2);
                if(k-j == m - k) res++;
            }
        }
        return res;
    }
}