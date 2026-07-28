class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        int cnt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'L') cnt++;
            else cnt--;
            if(cnt == 0) res++;
        }
        return res;
    }
}