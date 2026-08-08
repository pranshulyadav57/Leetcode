class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suff = new int[m];
        int i = n - 1;
        int j = m - 1;
        Arrays.fill(suff , -1);
        while(i >= 0 && j >= 0){
            if(word1.charAt(i) == word2.charAt(j)){
                suff[j] = i;
                j--;
            }
            i--;
        }
        int[] res = new int[m];
        boolean skip = false;
        j = 0;
        for(i = 0 ; i < n && j < m ; i++ ){
            if(word1.charAt(i) == word2.charAt(j)){
                res[j] = i;
                j++;
            }
            else if(!skip && (j == m-1  || i <suff[j+1])){
                res[j] = i;
                j++;
                skip = true;
            }
        }
        if(j == m) return res;
        return new int[]{};
    }
}