class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length; 
        // To create an adjacency list 'l' 
        List<List<Integer>> l = new ArrayList<>();

        // Creating adjacency list from the adjacency matrix
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    // Adding connected nodes to the adjacency list
                    l.get(i).add(j);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int count = 0; // Counter for connected components

        // Checking for each node whether it has any path or is part of a disjoint component
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                // Starting BFS from unvisited node
                q.add(i);
                visited.add(i);
                while (!q.isEmpty()) {
                    int current = q.poll();
                    for (int j : l.get(current)) {
                        if (!visited.contains(j)) {
                            q.add(j);
                            visited.add(j);
                        }
                    }
                }
                count++; // Increment count for each connected component found
            }
        }
        return count; // Returning the total count of connected components
    }
}

Intuition
The problem requires finding the number of connected components in an undirected graph. Connected components are subsets of nodes in a graph where each node is reachable from any other node in the same subset.
Approach
1.Adjacency List Creation:
The code begins by converting the given adjacency matrix isConnected into an adjacency list l. This conversion makes it easier to traverse the graph using lists of connected nodes for each node.
2.Breadth-First Search (BFS):
The main part of the code utilizes BFS to explore the graph and count the number of connected components.
It starts by iterating through each node.
For each unvisited node encountered, it initiates a BFS to explore all nodes connected to that node.
It keeps track of visited nodes using a HashSet (visited) to ensure nodes are not visited more than once.
During BFS, it traverses the connected nodes of the current node and marks them as visited, ensuring all nodes in the same component are accounted for.
3.Counting Connected Components:
Each time BFS is initiated from an unvisited node, it identifies a new connected component and increments the count variable to keep track of the total count of connected components.
4.Returning the Count:
Finally, the code returns the total count of connected components found in the graph.

  There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
  
Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
  
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
