class Solution {
    public String smallestNumber(String num, long t) {
        int[] req = new int[4];
        long temp = t;
        int[] primes = {2, 3, 5, 7};
        
        for (int i = 0; i < 4; i++) {
            while (temp % primes[i] == 0) {
                req[i]++;
                temp /= primes[i];
            }
        }
        
        if (temp > 1) return "-1";
        
        int n = num.length();
        int[][] dp = new int[60][40];
        
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 40; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int min = 1000;
                int[][] options = {{1, 0}, {0, 1}, {2, 0}, {1, 1}, {3, 0}, {0, 2}};
                
                for (int[] opt : options) {
                    int ni = Math.max(0, i - opt[0]);
                    int nj = Math.max(0, j - opt[1]);
                    
                    if (ni < i || nj < j) {
                        min = Math.min(min, 1 + dp[ni][nj]);
                    }
                }
                dp[i][j] = min;
            }
        }
        
        int zIdx = num.indexOf('0');
        if (zIdx == -1) zIdx = n;
        
        int[][] pref = new int[n + 1][4];
        for (int i = 0; i < zIdx; i++) {
            int d = num.charAt(i) - '0';
            for (int j = 0; j < 4; j++) pref[i + 1][j] = pref[i][j];
            int dTemp = d;
            for (int j = 0; j < 4; j++) {
                while (dTemp > 1 && dTemp % primes[j] == 0) {
                    pref[i + 1][j]++;
                    dTemp /= primes[j];
                }
            }
        }
        
        if (zIdx == n) {
            boolean valid = true;
            for (int j = 0; j < 4; j++) {
                if (pref[n][j] < req[j]) valid = false;
            }
            if (valid) return num;
        }
        
        for (int i = Math.min(n - 1, zIdx); i >= 0; i--) {
            int startD = (num.charAt(i) - '0') + 1;
            for (int d = Math.max(1, startD); d <= 9; d++) {
                int[] factors = getFactors(d);
                int remLen = n - 1 - i;
                if (canSatisfy(req, pref[i], factors, remLen, dp)) {
                    return buildString(num.substring(0, i) + d, req, pref[i], factors, remLen, dp);
                }
            }
        }
        
        int minLen = Math.max(n + 1, req[2] + req[3] + dp[Math.min(59, req[0])][Math.min(39, req[1])]);
        return buildString("", req, new int[4], new int[4], minLen, dp);
    }
    
    int[] getFactors(int d) {
        int[] f = new int[4];
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (d > 1 && d % primes[i] == 0) {
                f[i]++;
                d /= primes[i];
            }
        }
        return f;
    }
    
    boolean canSatisfy(int[] req, int[] pref, int[] curr, int remLen, int[][] dp) {
        int r2 = Math.max(0, req[0] - pref[0] - curr[0]);
        int r3 = Math.max(0, req[1] - pref[1] - curr[1]);
        int r5 = Math.max(0, req[2] - pref[2] - curr[2]);
        int r7 = Math.max(0, req[3] - pref[3] - curr[3]);
        
        r2 = Math.min(r2, 59);
        r3 = Math.min(r3, 39);
        
        return r5 + r7 + dp[r2][r3] <= remLen;
    }
    
    String buildString(String prefix, int[] req, int[] pref, int[] curr, int remLen, int[][] dp) {
        StringBuilder sb = new StringBuilder(prefix);
        int[] currentFactors = new int[4];
        for (int i = 0; i < 4; i++) currentFactors[i] = pref[i] + curr[i];
        
        for (int i = 0; i < remLen; i++) {
            for (int d = 1; d <= 9; d++) {
                int[] f = getFactors(d);
                if (canSatisfy(req, currentFactors, f, remLen - 1 - i, dp)) {
                    sb.append(d);
                    for (int j = 0; j < 4; j++) currentFactors[j] += f[j];
                    break;
                }
            }
        }
        return sb.toString();
    }
}