class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        findCombination(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void findCombination(int start, int target, int size, List<Integer> comb, List<List<Integer>> result) {

        // if target get zero it means the combination generated successfully
        if (target == 0) {
            // only add the results
            // if the generated combination is matches with given k
            if (comb.size() == size) {
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        // for every i there will possible value i to 9
        for (int i = start; i <= 9; i++) {
            if (i <= target) {
                comb.add(i);
                findCombination(i + 1, target - i, size, comb, result);
                comb.remove(comb.size() - 1);
            } else {
                break;
            }

        }

    }
}

// Approach
// -> The possibility came from 1 to 9 .
// -> Every i value the combination can be start from i to 9.
// -> whenever the i value which is lesser than target the i will be added in
// current Combination.
// -> The Target will reduce like target - i . then remaining target
// -> will passed to next method call
// -> Current combination only ended
// if the target gets zero or the current i value greater than
// remaining Target.
// -> if the target gets zero and also the current generated combination
// will be equal to k length.
// -> then this will be added List of list(List<List>).


Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination
