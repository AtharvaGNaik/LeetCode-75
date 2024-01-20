// class Solution {
//     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//         boolean[] n1 = new boolean[2001];
//         boolean[] n2 = new boolean[2001];

//         ArrayList<Integer> dif1 = new ArrayList<>();
//         ArrayList<Integer> dif2 = new ArrayList<>();

//         for (int num : nums1) {
//             n1[num + 1000] = true;
//         }

//         for (int num : nums2) {
//             n2[num + 1000] = true;

//             if (!n1[num + 1000]) {
//                 n1[num + 1000] = true;  // to avoid duplications
//                 dif2.add(num);
//             }
//         }

//         for (int num : nums1) {
//             if (!n2[num + 1000]) {
//                 n2[num + 1000] = true;  // to avoid duplications
//                 dif1.add(num);
//             }
//         }

//         return List.of(dif1, dif2);
//     }
// }

class Solution {
       public List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        ArrayList<Integer> diff1 = new ArrayList<>();
        ArrayList<Integer> diff2 = new ArrayList<>();


        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
            if (set1.add(i)) {
                diff2.add(i);
            }
        }

        for (int i : nums1) {
            if (set2.add(i)) {
                diff1.add(i);
            }
        }

        return List.of(diff1, diff2);
    }
}





// Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

// answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
// answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
// Note that the integers in the lists may be returned in any order.

 

// Example 1:

// Input: nums1 = [1,2,3], nums2 = [2,4,6]
// Output: [[1,3],[4,6]]
// Explanation:
// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
// Example 2:

// Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
// Output: [[3],[]]
// Explanation:
// For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
// Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
