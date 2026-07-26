class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        int[] arr = new int[n];
        int[] res = new int[nums1.length];
        for(int i = n-1 ; i>=0; i-- ){
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            if(st.isEmpty()) arr[i] = -1;
            else{
                arr[i] = st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i =0 ; i<nums1.length; i++){
            for(int j = 0 ; j < n; j++){
                if(nums1[i] == nums2[j]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }
}