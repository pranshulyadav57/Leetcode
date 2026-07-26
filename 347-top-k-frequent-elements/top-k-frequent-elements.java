class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> hp = new HashMap<>();
        for(int i : nums){
            hp.put(i , hp.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(Map.Entry<Integer ,Integer> e : hp.entrySet()){
            pq.add(new int[] {e.getKey() , e.getValue()});
        }
        int[] res = new int[k];
        int i = 0;
        while(i < k){
            int[] arr = pq.poll();
            res[i] = arr[0];
            i++;
        }
        return res;
    }
}