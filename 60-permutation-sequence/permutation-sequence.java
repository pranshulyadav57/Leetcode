class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        // Calculate factorial of n-1
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n); // Add last element (n)

        StringBuilder ans = new StringBuilder();
        k = k - 1; // Convert k to 0-based index

        while (true) {
            ans.append(numbers.get(k / fact)); // Add the digit at the position
            numbers.remove(k / fact); // Remove that number from the list

            if (numbers.isEmpty()) {
                break; // Exit when all numbers are used
            }

            k = k % fact; // Reduce k to fit within the remaining sub-permutation
            fact = fact / numbers.size(); // Update factorial for the remaining numbers
        }

        return ans.toString(); // Return the Kth permutation sequence
    }

    /*public String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }
        List<List<Integer>> per = new ArrayList<>();
        fxn(0, l, per);
        StringBuilder sb = new StringBuilder();
        for (int i : per.get(k - 1)) {
            sb.append(i);
        }
        return sb.toString();

    }

    void fxn(int i, List<Integer> l, List<List<Integer>> per) {
        if (i == l.size()) {
            List<Integer> t = new ArrayList<>();
            for (int n : l) {
                t.add(n);
            }
            per.add(new ArrayList<>(t));
        }
        for (int j = i; j < l.size(); j++) {
            swap(l, i, j);
            fxn(i + 1, l, per);
            swap(l, i, j);
        }
    }

    void swap(List<Integer> l, int i, int j) {
        int temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }*/
}