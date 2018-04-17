/*
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (28.50%)
 * Total Accepted:    454.2K
 * Total Submissions: 1.6M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode r = result;
        int carry = 0;
        while(l1 != null && l2 != null) {
            r.next = new ListNode(l1.val + l2.val + carry);
            r = r.next;
            carry = r.val > 9 ? 1 : 0;
            r.val = carry == 1 ? r.val - 10 : r.val;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            r.next = new ListNode(l1.val + carry);
            r = r.next;
            carry = r.val > 9 ? 1 : 0;
            r.val = carry == 1 ? r.val - 10 : r.val;
            l1 = l1.next;
        }

        while(l2 != null) {
            r.next = new ListNode(l2.val + carry);
            r = r.next;
            carry = r.val > 9 ? 1 : 0;
            r.val = carry == 1 ? r.val - 10 : r.val;
            l2 = l2.next;
        }

        if(carry == 1) {
            r.next = new ListNode(1);
        }

        return result.next;
    }
}
