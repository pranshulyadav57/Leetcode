class Solution {
    public int countRotations(String s, int k) {
        int validRotations = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int score = 0;
            
            for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                if (s.charAt(j) == s.charAt((j - 1 + n) % n)) {
                    score++;
                }
            }
            if (score == k) {
                validRotations++;
            }
        }
        
        return validRotations;
    }
}