class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n = prices.length;
        int m = discounts.length;
        int i = n-1;
        int j = m-1;
        double res = 0;
        while(i >=0 && j >=0){
            double price = (double) ((prices[i]) * (100-discounts[j])) / 100;
            res += price;
            i--;
            j--;
        }
        while(i >=0){
            res += (double)prices[i];
            i--;
        }
        return res;
    }
}