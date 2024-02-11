class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int total=rooms.size();
      boolean flag[]=new boolean[total];
      flag[0]=true;
      Queue<Integer>q=new LinkedList<>();
      for(int i=0;i<rooms.get(0).size();i++){
          q.add(rooms.get(0).get(i));
      }
      while(!q.isEmpty()){
          int curr=q.poll();
          if(flag[curr]==false){
              flag[curr]=true;
              for(int i=0;i<rooms.get(curr).size();i++){
                  q.add(rooms.get(curr).get(i));
              }
          }
      } 
      for(int i=0;i<total;i++){
          if(flag[i]==false) return false;
      }
      return true;
    }
}

// Example 1:

// Input: rooms = [[1],[2],[3],[]]
// Output: true
// Explanation: 
// We visit room 0 and pick up key 1.
// We then visit room 1 and pick up key 2.
// We then visit room 2 and pick up key 3.
// We then visit room 3.
// Since we were able to visit every room, we return true.

// Example 2:

// Input: rooms = [[1,3],[3,0,1],[2],[0]]
// Output: false
// Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
