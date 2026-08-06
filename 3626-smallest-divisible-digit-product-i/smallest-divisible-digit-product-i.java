class Solution {
    public int smallestNumber(int n, int t) {
        int res = 0;
        for(int i = n ; i <= n + 10; i++){
            int j = i;
            int p = 1;
            while(j > 0){
                p = p * (j % 10);
                j /= 10;
            }
            if(p % t == 0){
                res = i;
                break;
            }
        }
        return res;
    }
}