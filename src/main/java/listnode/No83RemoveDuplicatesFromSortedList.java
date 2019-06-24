package listnode;

import org.junit.Test;

import java.util.List;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class No83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicates1(head);
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    private ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    @Test
    public void testCase1() {
        /*
            输入: 1->1->2
            输出: 1->2
         */
        ListNode listNode = ListNode.of("1,1,2");
        ListNode deleteDuplicates = deleteDuplicates(listNode);
        System.out.println(deleteDuplicates);
    }

    @Test
    public void testCase2() {
        /*
            输入: 1->1->2->3->3
            输出: 1->2->3
         */
        ListNode listNode = ListNode.of("1,1,2,3,3");
        ListNode deleteDuplicates = deleteDuplicates(listNode);
        System.out.println(deleteDuplicates);
    }

    @Test
    public void testCase3() {
        /*
            输入: []
            输出: null
         */
        ListNode listNode = null;
        ListNode deleteDuplicates = deleteDuplicates(listNode);
        System.out.println(deleteDuplicates);
    }
}
