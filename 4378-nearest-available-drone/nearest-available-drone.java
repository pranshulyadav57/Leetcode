class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx = -1;
        int cur = 1001;
        for(int i = 0 ; i < drones.length ; i++){
            int dis = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1]-target[1]);
            if(dis <= drones[i][2] && dis < cur){
                idx = i;
                cur = dis;
            }
        }
        return idx;
    }
}