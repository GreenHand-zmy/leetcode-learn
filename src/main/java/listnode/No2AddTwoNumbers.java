package listnode;

import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class No2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode root = result;

        // 合并链表
        while (true) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }

            result.next = new ListNode(temp);
            result = result.next;

            if (l1 == null && l2 == null) {
                break;
            }
        }

        result = root.next;

        // 进位
        while (result != null) {
            if (result.val - 9 > 0) {
                result.val %= 10;

                if (result.next == null) {
                    result.next = new ListNode(1);
                } else {
                    result.next.val += 1;
                }

            }
            result = result.next;
        }
        return root.next;
    }

    @Test
    public void testCase1() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
    }
}

