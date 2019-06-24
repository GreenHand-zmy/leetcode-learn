package listnode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class No160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNode3(headA, headB);
    }

    /**
     * 暴力法，双层循环，先遍历A节点然后遍历B节点，如果有相同的则返回。
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(1)
     */
    private ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
            }
        }

        return null;
    }

    /**
     * 哈希表法，将链表A节点保存到hash表中，在遍历链表B的同时，检测表中是否有相同节点。
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(m) or O(n)
     */
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            set.add(nodeA);
        }

        for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
            if (set.contains(nodeB)) {
                return nodeB;
            }
        }
        return null;
    }

    /**
     * 可以把有交点的线段通过交点分成三段A1，m，B1。
     * 因为A1+m+B1长度是固定的，所以设置两个指针，指针A从A线段走到末尾然后就在B开头走，B也是相同。
     * 然后它们就会碰见了。
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(m) or O(n)
     */
    private ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }

            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }

    @Test
    public void testCase1() {
        ListNode listNode1 = ListNode.of("1,2,3,4,5,6");
        ListNode listNode2 = ListNode.of("1,2,3");

        ListNode intersectionNode = getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode);
    }
}
