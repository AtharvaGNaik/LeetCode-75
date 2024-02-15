
https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/solutions/2834883/java-bfs-solution-with-explanation

class Solution {
    class Pair{
        int row, col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vis = new int[m][n];
        maze[entrance[0]][entrance[1]] = '*';

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && maze[i][0]=='.'){
                q.add(new Pair(i, 0, 0));
                vis[i][0]=1;
            }

            if(vis[i][n-1]==0 && maze[i][n-1]=='.'){
                q.add(new Pair(i, n-1, 0));
                vis[i][n-1]=1;
            }
        }

        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && maze[0][i]=='.'){
                q.add(new Pair(0, i, 0));
                vis[0][i]=1;
            }
            if(vis[m-1][i]==0 && maze[m-1][i]=='.'){
                q.add(new Pair(m-1, i, 0));
                vis[m-1][i]=1;
            }
        }

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && maze[nrow][ncol]=='*')
                    return dist+1;

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && maze[nrow][ncol]=='.'){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol, dist+1));
                }
            }
        }
        return -1;
    }
}



Intuition
Instead of travelling from entrance to nearest exit, travel from nearest exit to the entrace and find the minimum distance.

Approach
We can solve this problem using BFS and initally add all the boundary rows and columns which are not walls to the queue (these points are the nearest exits). For each of these exit points, find the next valid point and if the point turns out to be entrance, return it,

Complexity
Time complexity:
O(V+E)O(V+E)O(V+E)

Space complexity:
O(n)O(n)O(n)

  
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:
Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

Example 2:
Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.

Example 3:
Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
