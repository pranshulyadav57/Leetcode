class Solution {
    int[] bit;
    int n;
    void update(int idx , int val){
        while(idx <= n){
            bit[idx] += val;
            idx += idx & -idx;
        }
    }
    int query(int idx){
        int sum = 0;
        while(idx > 0){
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
    public String minInteger(String num, int k) {
        n = num.length();
        bit = new int[n+2];
        boolean[] vis = new boolean[n];
        Queue<Integer>[] digit = new LinkedList[10];
        for(int i = 0 ; i < 10 ; i++){
            digit[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < n ; i++){
            digit[num.charAt(i) - '0'].add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < n && k > 0){
            for(int i = 0 ; i < 10; i++){
                if(digit[i].isEmpty()) continue;
                int idx = digit[i].peek();
                int cost = idx - query(idx);
                if(cost <= k){
                    k -= cost;
                    sb.append(i);
                    vis[idx] = true;
                    digit[i].poll();
                    update(idx + 1 , 1);
                    break;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]) sb.append(num.charAt(i)-'0');
        }
        return sb.toString();
    }
}