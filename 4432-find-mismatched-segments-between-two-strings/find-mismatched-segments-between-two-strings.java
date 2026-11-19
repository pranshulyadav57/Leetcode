class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res = new ArrayList<>();
        int i = 0;
        int n = s1.length();
        while(i < n){
            if(s1.charAt(i) != s2.charAt(i)){
                int j = i;
                List<String> l = new ArrayList<>();
                while(j < n && s2.charAt(j) != s1.charAt(j)){
                    j++;
                }
                l.add(s1.substring(i,j));
                l.add(s2.substring(i,j));
                i = j;
                res.add(l);
            }
            i++;
        }
        return res;
    }
}