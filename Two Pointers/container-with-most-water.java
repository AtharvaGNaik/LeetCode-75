class Solution {
    public int maxArea(int[] height) {
        int maxA = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            // Calculate the width between the two pointers
            int width = r - l;

            // Calculate the height of the container (minimum height between the two lines)
            int h = Math.min(height[l], height[r]);

            // Calculate the current area and update maxArea if needed
            int currentA = width * h;
            maxA = Math.max(maxA, currentA);

            // Move pointers towards each other
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxA;

    }
}



// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

 

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1



  
// The problem is to find the two vertical lines in a given set of lines represented by the height array, such that these two lines and the x-axis form a container. The goal is to maximize the amount of water that can be contained by the container.

// Each element height[i] in the array represents the height of a vertical line at position i. The two endpoints of the line are (i, 0) and (i, height[i]). The container is formed by selecting two lines and the x-axis. The width of the container is determined by the difference in the positions of the selected lines, and the height of the container is determined by the minimum height of the two selected lines.

// The task is to find the pair of lines that maximize the area of the container. The area of the container is calculated as the product of its width and height: width * min(height[i], height[j]), where i and j are the indices of the selected lines.

// The two-pointer approach efficiently explores possible pairs of lines by starting with pointers at both ends of the array and moving them towards each other. At each step, the width between the two pointers is calculated, and the height of the container is determined by the minimum height of the lines at the current pointer positions. The maximum area is updated if the current area is greater.

// The process continues until the two pointers meet, exploring all possible pairs and finding the maximum area of the container that can hold water.
