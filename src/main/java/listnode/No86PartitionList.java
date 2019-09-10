package listnode;

import org.junit.Test;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class No86PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0), leftCurrent = left;
        ListNode right = new ListNode(0), rightCurrent = right;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                leftCurrent.next = current;
                leftCurrent = leftCurrent.next;
            } else {
                rightCurrent.next = current;
                rightCurrent = rightCurrent.next;
            }
            current = current.next;
        }
        rightCurrent.next = null;

        leftCurrent.next = right.next;

        System.out.println(left);
        return left.next;
    }

    /**
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     */
    @Test
    public void testCase1() {
        ListNode listNode = ListNode.of("1,4,3,2,5,2");
        ListNode partition = partition(listNode, 3);
        System.out.println(partition);
    }
}
