/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int mn = Integer.MAX_VALUE;
        int mx = -1;
        int idx = 1;
        int j = -1;
        int i = -1;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur.next != null){
            if((cur.val > prev.val && cur.val > cur.next.val) || (cur.val < prev.val && cur.val < cur.next.val)){
                if(i == -1) {
                    i = idx;
                    j = i;
                }
                else{
                    mn = Math.min(mn , idx - j);
                    mx = Math.max(mx , idx - i);
                    j = idx;
                }
            }
            idx++;
            prev = cur;
            cur = cur.next;
        }
        mn = (mn == Integer.MAX_VALUE) ? -1 : mn;
        return new int[]{mn,mx};
    }
}