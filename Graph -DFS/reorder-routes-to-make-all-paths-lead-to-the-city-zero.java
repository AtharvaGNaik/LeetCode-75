class Solution {
    public int minReorder(int n, int[][] connections) {

        HashMap<Integer,List<Integer>> adjc = new HashMap<>();
        HashSet<List<Integer>> edges = new HashSet<>();
        HashSet<Integer> visited = new HashSet();

        Queue<Integer> q = new LinkedList<>();
        int changes =0;


        for( int[] a : connections)
        {
            List<Integer> edge = new ArrayList();
            edge.add(a[0]);
            edge.add(a[1]);
            edges.add(edge);
            System.out.println(edge);

            List<Integer> l1 = adjc.getOrDefault(a[0],new ArrayList());
            List<Integer> l2 = adjc.getOrDefault(a[1],new ArrayList());

            l1.add(a[1]);
            l2.add(a[0]);
            adjc.put(a[0],l1);
            adjc.put(a[1],l2);
        }

        q.add(0);

        while(!q.isEmpty())
        {
            int node = q.poll();
            visited.add(node);

            for(Integer neigh : adjc.get(node))
            {
                if(!visited.contains(neigh))
                {
                    q.add(neigh);
                    List<Integer> nedge = new ArrayList();
                    nedge.add(neigh);
                    nedge.add(node);
                    
                    if(!edges.contains(nedge)) changes++;
                    
                }
            }
        }
        return changes;
    }
}
// create a map {city : neighbours} and set of all the edges

// now do a bfs and check on every city if there is an edge (neigh, city) in our edge set, if its not their increase the changes count. and move on to next city. keep visited set to avoid checking the already checked node.
// There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
// Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
// This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
// Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
// It's guaranteed that each city can reach city 0 after reorder.

// Example 1:

// Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
// Output: 3
// Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

// Example 2:
// Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
// Output: 2
// Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

// Example 3:
// Input: n = 3, connections = [[1,0],[2,0]]
// Output: 0
