class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int val : asteroids) {
            if(st.isEmpty() || val > 0) {
                st.push(val);
            }
            else {
                while(true) {
                    int peek = st.peek();
                    if(peek < 0) {
                        st.push(val);
                        break;
                    }
                    else if(peek == -val) {
                        st.pop();
                        break;
                    }
                    else if(peek > -val) {
                        break;
                    }
                    else {
                        st.pop();
                        if(st.isEmpty()) {
                            st.push(val);
                            break;
                        }
                    }
                }
            }
        }

        int i = st.size();
        int ans[] = new int[i];
        while(!st.isEmpty()) {
            if(i > 0)
                ans[i-1] = st.pop();
                i--;
        }
        return ans;
    }
}




// Intuition
// Suppose a row of asteroid is stable, if we add a new asteroid on the right which is +ve, so it won't collide.
// If the last element of the row is -ve, no matter which asteroid is gonna come, they will never collide.
// Collision will only take place when lefmost or peek element is +ve and the new element which is coming is negative.
// ApproachA
// stack (st) is used to keep track of the asteroids that have not collided yet.
// The code iterates through the given array of asteroids using a for-each loop.
// For each asteroid (val):
// If the stack is empty or the asteroid is moving to the right (positive value), it is pushed onto the stack because it won't collide with anything.
// If the asteroid is moving to the left (negative value), a collision check is performed using a while loop.
// Within the while loop:
// If the stack is empty or the top of the stack is negative (representing an asteroid moving to the left), the current asteroid is pushed onto the stack, and the loop breaks.
// If the top of the stack is of the same magnitude but opposite sign as the current asteroid, both asteroids are destroyed (popped from the stack), and the loop breaks.
// If the top of the stack is greater in magnitude than the current asteroid, the current asteroid is destroyed, and the loop breaks.
// If none of the above conditions are met, the top of the stack is popped, and the loop continues.
// After processing all asteroids, the remaining elements in the stack represent the surviving asteroids.
// The remaining elements in the stack are popped and stored in an array (ans), which is then returned.




// We are given an array asteroids of integers representing asteroids in a row.
// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

// Example 1:
// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

// Example 2:
// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.

// Example 3:
// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
