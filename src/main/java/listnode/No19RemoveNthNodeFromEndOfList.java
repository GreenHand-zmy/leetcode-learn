package listnode;

import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：给定的 n 保证是有效的。
 */
public class No19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd2(head, n);
    }

    /**
     * 两次遍历法
     */
    private ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 算出长度
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }

        if (n > length) {
            throw new RuntimeException("n is invaild");
        }

        // 移动到被删除元素的前一位
        int index = length - n;
        ListNode temp = dummyHead;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        // 进行删除
        temp.next = temp.next.next;

        return dummyHead.next;
    }


    private Integer back = 0;

    /**
     * 递归法
     */
    private ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        remove(dummyHead, n);

        return dummyHead.next;
    }

    private void remove(ListNode current, int n) {
        if (current == null) {
            return;
        }

        remove(current.next, n);

        back++;
        if (back - 1 == n) {
            current.next = current.next.next;
        }
    }

    private ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode first = dummyHead;
        ListNode second = dummyHead;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummyHead.next;
    }

    @Test
    public void testCase1() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode node = removeNthFromEnd(root, 1);
        System.out.println(node);
    }
}
