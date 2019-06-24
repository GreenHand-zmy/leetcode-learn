package listnode;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class No141LinkedListCycle {
    /**
     * 设置快慢指针，两个指针如果相遇，则说明有环。
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public boolean hasCycle(ListNode head) {
        // 空/单元素不会成环
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
    }
}
