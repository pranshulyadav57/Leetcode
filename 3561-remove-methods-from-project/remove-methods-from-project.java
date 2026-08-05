class Solution {
    boolean[] vis;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < invocations.length; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            adj.get(u).add(v);
        }
        vis = new boolean[n];
        Set<Integer> set = new HashSet<>();
        dfs(k , adj , set);
        for(int i = 0 ; i < invocations.length; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            if(set.contains(v) && !set.contains(u)){
                Arrays.fill(vis , false);
                break;
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]) l.add(i);
        }
        return l;
    }
    void dfs(int src , List<List<Integer>> adj , Set<Integer> set){
        vis[src] = true;
        set.add(src);
        for(int v : adj.get(src)){
            if(!vis[v])dfs(v , adj, set);
        }
    }
}