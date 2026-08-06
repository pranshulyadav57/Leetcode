class Solution {
    int[][] dir = {{0,1} , {0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                res[i][j] = Integer.MAX_VALUE;
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                    q.add(new int[] {i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] u = q.poll();
            int i = u[0];
            int j = u[1];
            for(int k = 0 ; k<4 ; k++){
                int ri = i + dir[k][0];
                int cj = j + dir[k][1];
                if(ri>=0 && ri<n && cj>=0 && cj<m && res[ri][cj] > 1+res[i][j]){
                    res[ri][cj] = 1 + res[i][j];
                    q.add(new int[] {ri,cj});
                }
            }    
        }
        return res;
    }
}