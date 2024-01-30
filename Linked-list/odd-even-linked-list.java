


// Use easy two pointers method - Beats 100% Code

// Approach
// Edge cases :
// If there are less than 3 elements in the List, No change is required. Return head

// if(head == null || head.next == null || head.next.next ==null) { 
//     return head; 
// }
// Reference Variables :
// Take first node as 'first' & second node as 'second'.
// The 2nd node will be the head of the even set of nodes.

// ListNode head2 = head.next;
// ListNode first = head, second = head.next, prev = null;
// Linking:
// We can link the even and the odd nodes using the following logic

// while(second!=null && first!=null)
// {
//     first.next = second.next;
//     prev = first;
//     first = first.next;
//     if(first!=null)
//     {
//         second.next = first.next;
//         second = second.next;
//     }
// }
// Merging the even and the odd list
// If we observe by tracing with pen & paper we can see -

// If no of nodes is odd -- (second == null)
// And tail of odd set of nodes is 'first'
// if (second == null) {
//     first.next = head2;
// }
// If no of nodes is even -- (first == null)
// tail of odd set of nodes is 'prev'
// else {
//     prev.next = head2;
// }
// return head;






/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next ==null)
        {
            return head;
        }
        ListNode head2 = head.next;
        ListNode first = head, second = head.next,prev = null;
        while(second!=null && first!=null)
        {
            first.next = second.next;
            prev = first;
            first = first.next;
            if(first!=null)
            {
                second.next = first.next;
                second = second.next;
            }
        }
        //If no of nodes is odd -- (second == null)
        //tail of odd set of nodes is 'first'
        if(second==null)
        {
            first.next = head2;
        }
        //If no of nodes is even -- (first == null)
        //tail of odd set of nodes is 'prev'
        else  
        {
            prev.next = head2;
        }
        return head;
    }
}


// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

// The first node is considered odd, and the second node is even, and so on.

// Note that the relative order inside both the even and odd groups should remain as it was in the input.

// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]
// Example 2:


// Input: head = [2,1,3,5,6,4,7]
// Output: [2,3,6,7,1,5,4]
