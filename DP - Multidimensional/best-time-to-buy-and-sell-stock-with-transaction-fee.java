
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/submissions/1194952459/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}

Intuition
The intuition behind the solution is to keep track of the minimum cost to buy a stock at each day and the maximum profit that can be achieved by selling the stock at each day.

Approach:
Initialize two variables: buy and sell. Set buy to negative infinity and sell to zero. These variables will keep track of the maximum profit at each day.
Iterate through the prices of the stocks starting from the first day.
Update the buy variable by taking the maximum of its current value and the previous sell value minus the stock price. This represents the maximum profit after buying the stock.
buy = max(buy, sell - price)
Update the sell variable by taking the maximum of its current value and the previous buy value plus the stock price minus the transaction fee. This represents the maximum profit after selling the stock.
sell = max(sell, buy + price - fee)
After iterating through all the prices, the maximum profit will be stored in the sell variable.
Return the value of sell as the maximum profit.



// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction
// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).The transaction fee is only charged once for each stock purchase and sale.
  
// Example 1:
// Input: prices = [1,3,2,8,4,9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// - Buying at prices[0] = 1
// - Selling at prices[3] = 8
// - Buying at prices[4] = 4
// - Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
  
// Example 2:
// Input: prices = [1,3,7,5,10,3], fee = 3
// Output: 6
