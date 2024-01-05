class Solution {
    public String reverseVowels(String s) {

        List<Character> vowels = new ArrayList<>();
        List<Integer> ind = new ArrayList<>();
        String v = "aeiouAEIOU";

        // Identify vowels and their indices
        for (int i = 0; i < s.length(); i++) {
            if (v.indexOf(s.charAt(i)) != -1) {
                vowels.add(s.charAt(i));
                ind.add(i);
            }
        }

        // Use StringBuilder to modify the string
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = ind.size() - 1; i <= j; i++, j--) {
            sb.setCharAt(ind.get(i), vowels.get(j));
            sb.setCharAt(ind.get(j), vowels.get(i));
        }

        return sb.toString();
    }



// ANother APPROach


// public class Solution {
//     public String reverseVowels(String s) {
//         char[] vowels = new char[s.length()];
//         int[] ind = new int[s.length()];
//         String v = "aeiouAEIOU";

//         int count = 0;

//         // Identify vowels and their indices
//         for (int i = 0; i < s.length(); i++) {
//             if (v.indexOf(s.charAt(i)) != -1) {
//                 vowels[count] = s.charAt(i);
//                 ind[count] = i;
//                 count++;
//             }
//         }

//         // Use StringBuilder to modify the string
//         StringBuilder sb = new StringBuilder(s);
//         for (int i = 0, j = count - 1; i < j; i++, j--) {
//             sb.setCharAt(ind[i], vowels[j]);
//             sb.setCharAt(ind[j], vowels[i]);
//         }

//         return sb.toString();
//     }
// }





// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"
 
