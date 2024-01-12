class Solution {
    public boolean halvesAreAlike(String s) {
        int a=0,b=0,l=s.length();
        String vow="aeiouAEIOU";
        for(int i=0, j=(l/2) ; i<l/2 && j<l;i++,j++){
            if(vow.indexOf(s.charAt(i)) != -1){
              a++;
            }
            if(vow.indexOf(s.charAt(j)) != -1){
              b++;
            }
        }
        return a == b;
    }
}

// You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

// Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

// Return true if a and b are alike. Otherwise, return false.

 

// Example 1:

// Input: s = "book"
// Output: true
// Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
// Example 2:

// Input: s = "textbook"
// Output: false
// Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
// Notice that the vowel o is counted twice.
 
