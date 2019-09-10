package listnode;

import org.junit.Test;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class No24SwapNodesInPairs {
    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode current = head;
        ListNode prev = dummyNode;

        while (current != null) {
            // 有下一个节点才可以交换
            if (current.next != null) {
                ListNode tempNode = current.next;
                current.next = current.next.next;

                ListNode temp = prev.next;
                prev.next = tempNode;
                tempNode.next = temp;
            }

            prev = current;
            current = current.next;
        }

        return dummyNode.next;
    }

    @Test
    public void testCase1() {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        ListNode listNode = ListNode.of("1,2,3,4");
        ListNode result = swapPairs(listNode);
        System.out.println(result);
    }

    @Test
    public void testCase2() {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        ListNode listNode = ListNode.of("1");
        ListNode result = swapPairs(listNode);
        System.out.println(result);
    }

    @Test
    public void testCase3() {
        ListNode result = swapPairs(null);
        System.out.println(result);
    }

    @Test
    public void testCase4() {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        ListNode listNode = ListNode.of("1,2,3");
        ListNode result = swapPairs(listNode);
        System.out.println(result);
    }
}
