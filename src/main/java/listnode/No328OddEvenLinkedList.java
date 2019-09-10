package listnode;

import org.junit.Test;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class No328OddEvenLinkedList {
    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 奇数节点
        ListNode odd = head, oddCurrent = odd;
        // 偶数节点
        ListNode even = head.next, evenCurrent = even;

        while (evenCurrent != null && oddCurrent != null) {
            if (oddCurrent.next != null) {
                oddCurrent.next = oddCurrent.next.next;
                oddCurrent = oddCurrent.next;
            }

            if (evenCurrent.next != null) {
                evenCurrent.next = evenCurrent.next.next;
                evenCurrent = evenCurrent.next;
            }

        }

        // 将偶数节点插入奇数节点末尾
        oddCurrent = odd;
        while (oddCurrent.next != null) {
            oddCurrent = oddCurrent.next;
        }
        oddCurrent.next = even;

        return odd;
    }

    @Test
    public void testCase1() {
        ListNode listNode = ListNode.of("1,2,3,4,5,6");

        ListNode node = oddEvenList(listNode);
        System.out.println(node);
    }

    @Test
    public void testCase2() {
        ListNode listNode = ListNode.of("1,2,3,4,5,6,7");

        ListNode node = oddEvenList(listNode);
        System.out.println(node);
    }
}
