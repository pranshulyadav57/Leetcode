class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> l = new ArrayList<>();
        fxn(0 , s , l , res);
        return res;
    }
    void fxn(int i , String s , List<String> l , List<List<String>> res){
        if(i == s.length()){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int end = i +1; end <= s.length() ; end++){
            if(check(s , i , end-1)){
                l.add(s.substring(i , end));
                fxn(end , s , l , res);
                l.remove(l.size()-1);
            }
        }
    }
    boolean check(String s , int l , int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}