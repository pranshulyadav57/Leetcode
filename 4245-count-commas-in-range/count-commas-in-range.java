class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        int c = 0;
        if(n>= 1000){
            c+= n-1000+1;
        }
        if(n>=1000000) c+=n-1000000+1;
        return c;
    }
}