package com.aqiu._3_Array_String;

public class _7_P121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new _7_P121_BestTimeToBuyAndSellStock().new Solution();
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else if (price - minPrice > maxProfit) {
                    maxProfit = price - minPrice;
                }
            }
            return maxProfit;
        }
    }
}
