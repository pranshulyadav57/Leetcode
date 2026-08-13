class Solution {
    class Node {
        int pre;
        char preChar;
        int suf;
        char sufChar;
        int max;
        int size;
    }

    Node[] tree;
    char[] arr;

    void merge(int node, int left, int right) {
        tree[node].size = tree[left].size + tree[right].size;
        tree[node].preChar = tree[left].preChar;
        tree[node].sufChar = tree[right].sufChar;
        
        tree[node].pre = tree[left].pre;
        if (tree[left].pre == tree[left].size && tree[left].sufChar == tree[right].preChar) {
            tree[node].pre += tree[right].pre;
        }
        
        tree[node].suf = tree[right].suf;
        if (tree[right].suf == tree[right].size && tree[right].preChar == tree[left].sufChar) {
            tree[node].suf += tree[left].suf;
        }
        
        tree[node].max = Math.max(tree[left].max, tree[right].max);
        if (tree[left].sufChar == tree[right].preChar) {
            tree[node].max = Math.max(tree[node].max, tree[left].suf + tree[right].pre);
        }
    }

    void build(int node, int start, int end) {
        tree[node] = new Node();
        if (start == end) {
            tree[node].pre = 1;
            tree[node].suf = 1;
            tree[node].max = 1;
            tree[node].preChar = arr[start];
            tree[node].sufChar = arr[start];
            tree[node].size = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        merge(node, 2 * node, 2 * node + 1);
    }

    void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node].preChar = c;
            tree[node].sufChar = c;
            arr[idx] = c;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        merge(node, 2 * node, 2 * node + 1);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryCharacters.length();
        arr = s.toCharArray();
        tree = new Node[4 * n + 1];
        
        build(1, 0, n - 1);
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].max;
        }
        return ans;
    }
}