package listnode;

import org.junit.Test;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class No876MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        return middleNode2(head);
    }

    /**
     * 双次遍历法，第一次遍历得出链表的长度，根据长度选出中间节点。
     * 第二次遍历，选出中间节点。
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    private ListNode middleNode1(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }

        ListNode result = head;
        int index = length / 2;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result;
    }

    /**
     * 双指针法，设置快慢指针，慢指针一次走一步，快指针一次走两步。
     * 当快指针走到末尾，慢指针刚好在中间节点上。
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    private ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    @Test
    public void testCase1() {
        /*
         * 输入：[1,2,3,4,5]
         * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
         * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
         * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
         * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
         */

        ListNode listNode = ListNode.of("1,2,3,4,5");
        ListNode node = middleNode(listNode);
        System.out.println(node);
    }

    @Test
    public void testCase2() {
        /*
         * 输入：[1,2,3,4,5,6]
         * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
         * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
         */

        ListNode listNode = ListNode.of("1,2,3,4,5,6");
        ListNode node = middleNode(listNode);
        System.out.println(node);
    }
}
