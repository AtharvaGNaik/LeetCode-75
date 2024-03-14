class Node{
    Node links[]=new Node[26];
    boolean flag=false;
    
    public Node(){

    }

    public boolean containsKey(char ch)
    {
        return (links[ch-'a'] != null);
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch , Node node){
        links[ch-'a']=node;
    }

    void setEnd(){
        flag=true;
    }

    boolean isEnd(){
        return flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    
    public void insert(String word) {
        
        Node node=root;

        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }

        node.setEnd();
    }
    
    public boolean search(String words) {
        
        Node node= root;

        for(int i=0;i<words.length();i++)
        {
            if(!node.containsKey(words.charAt(i)))
                return false;

            node=node.get(words.charAt(i));
        }
        if(node.isEnd())
            return true;
        
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node= root;

        for(int i=0;i<prefix.length();i++)
        {
            if(!node.containsKey(prefix.charAt(i)))
                return false;

            node=node.get(prefix.charAt(i));
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */















// // Node for Trie -> Kind of a tree but a Node(letter) can have 26 childs(next letters)
// struct Node{
//     Node *links[26]; // childs of the current node
//     bool end = false; // If current element is last

//     void put(char ch){
//         Node *node = new Node();
//         links[ch-'a'] = node; // puts an empty node as link for the character
//     }

//     bool contains(char ch){
//         return (links[ch-'a'] != NULL); // Checks for availability of letter
//     }

//     Node *get(char ch){
//         return links[ch-'a']; // Gets the node of child letter
//     }

//     void setEnd(){ end=true; } // Sets end as true when the string ends
//     bool isEnd(){ return end; } // Checks for end of string
// };

// class Trie {
// private:
//     Node *root; // Start of Trie
// public:
//     Trie() {
//         root = new Node(); // new Object created (one-time)
//     }
    
//     void insert(string word) {
//         Node *cur = root;
//         for(auto ch: word){
//             if(!cur->contains(ch)){ // If char not in Node
//                 cur->put(ch); // Put as child
//             }
//             cur = cur->get(ch); // Move to next reference Node/trie
//         }
//         cur->setEnd();
//     }

//     bool searchUtil(string word, bool fullSearch){
//         Node *cur = root;
//         for(auto ch: word){
//             if(!cur->contains(ch)) return false; // If the char not present in Node/Trie return false
//             cur = cur->get(ch); // Move to next reference Node/trie
//         }
//         return (fullSearch? cur->isEnd() : true);
//     }

//     bool search(string word) {
//         return searchUtil(word, true); // searching for full word
//     }
    
//     bool startsWith(string word) {
//         return searchUtil(word, false); // searching for prefix only
//     }
// };

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */



// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
// Implement the Trie class:
// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

// Example 1:
// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
