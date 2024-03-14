class Node {
    Node[] links = new Node[26];
    public PriorityQueue < String > pq = new PriorityQueue < > (Comparator.reverseOrder());
    public Node() {}
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    public Node get(char ch) {
        return links[ch - 'a'];
    }
    public void addToPQ(String word) {
        pq.add(word);
        if (pq.size() > 3)
            pq.poll();
    }
    public List < String > getTopThree() {
        List < String > topThree = new ArrayList < > ();
        while (!pq.isEmpty())
            topThree.add(pq.poll());
        Collections.reverse(topThree);
        return topThree;
    }

}
class Solution {
    public List < List < String >> suggestedProducts(String[] products, String searchWord) {
        Node node = new Node();
        for (String prod: products)
            insert(node, prod);
        List < List < String >> results = new ArrayList < > ();
        for (int i = 0; i < searchWord.length(); i++) {
            if (!node.containsKey(searchWord.charAt(i)))
                break;
            node = node.get(searchWord.charAt(i));
            results.add(node.getTopThree());
        }
        while (results.size() < searchWord.length())
            results.add(new ArrayList < > ());
        return results;
    }
    public void insert(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.addToPQ(word);
        }
    }
}



Logic:
The approach I had in mind is quite simple! All we need to do is add each product to a prefix trie and then perform a depth-first-search through the trie for each character of our searchWord to add our three-word suggestions. The key bit of implementation here is that we're keeping track of those suggested words while we're inserting products into our trie.
The way we do this is by using the TrieNode class itself to store our suggested words:
At each TrieNode, we include a priority queue that stores up to 3 words that share the current character in the trie.
Our priority queue comparator will keep the larger lexicoographical word on top. The reason we do this is so that we can pop it off whenever our pq exceeds a size of 3.Therefore, our bottom 3 words that will never get popped off are the first lexicographically ordered words.Observe how we would build our Trie whilst keeping our 3-word storage in mind:As you can see, all we'd need to do once we've obtained our Trie structure, all we'd need to do was perform a depth-first search down the trie for each character of searchWord and collect the stored words at each node. We'll let our TrieNode class take care of all priority queue management, including building our list of three words.


//   You are given an array of strings products and a string searchWord.

// Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

// Return a list of lists of the suggested products after each character of searchWord is typed.

 

// Example 1:

// Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
// Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
// Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
// After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
// After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
// Example 2:

// Input: products = ["havana"], searchWord = "havana"
// Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// Explanation: The only word "havana" will be always suggested while typing the search word.
 

// Constraints:
