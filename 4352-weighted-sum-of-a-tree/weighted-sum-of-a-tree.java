class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = parent.length;

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int v = parent[i];
            adj.get(i).add(v);
            adj.get(v).add(i);
        }

        int[] level = new int[n];
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        level[0] = 1;

        int h = 1;

        while (!q.isEmpty()) {
            int u = q.poll();

            h = Math.max(h, level[u]);

            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    level[v] = level[u] + 1;
                    q.add(v);
                }
            }
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * (h - level[i] + 1);
        }

        return res;
    }
}