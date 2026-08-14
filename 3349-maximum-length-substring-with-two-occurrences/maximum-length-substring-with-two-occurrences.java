class Solution {
    public int maximumLengthSubstring(String s) {
        int len = 0;
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            int cur = 0;
            Arrays.fill(freq,0);
            for(int j = i ; j < s.length(); j++){
                freq[s.charAt(j)-'a']++;
                if(freq[s.charAt(j)-'a'] >2){
                    len = Math.max(len , cur);
                    break;
                }
                cur++;
            }
            len = Math.max(cur , len);
        }
        return len;
    }
}