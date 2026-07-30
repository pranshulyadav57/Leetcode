class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int q = n / 8;
        int r = n % 8;
        
        return (4 * q + r) * (q + 1);
    }
}