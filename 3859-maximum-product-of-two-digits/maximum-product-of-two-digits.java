class Solution {
    public int maxProduct(int n) {
        List<Integer> l = new ArrayList<>();
        while(n > 0){
            l.add(n%10);
            n /= 10;
        }
        int res = 0;
        for(int i = 0 ; i < l.size(); i++){
            for(int j = i +1 ; j < l.size(); j++){
                res = Math.max(res , l.get(i) * l.get(j));
            }
        }
        return res;
    }
}