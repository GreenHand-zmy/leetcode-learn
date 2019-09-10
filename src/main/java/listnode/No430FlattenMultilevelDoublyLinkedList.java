package listnode;

import org.junit.Test;

/**
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 */
public class No430FlattenMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * 解题思路:因为是多级链表,所以第一想法就想到了用递归来处理,在每次递归中合并两级单链表。
     * 递归的思路就是从多级链表的头开始遍历,如果遇见下一级就进入递归,在递归返程时将链表连接到正确位置。
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node children = flatten(cur.child);

                Node childrenCur = children;
                while (childrenCur.next != null) {
                    childrenCur = childrenCur.next;
                }

                // 接尾
                childrenCur.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = childrenCur;
                }

                // 续头
                cur.next = children;
                children.prev = cur;

                // 去除child
                cur.child = null;

                // 优化,当子链表接上后,当前结点在子链表的头,优化为在子链的尾,少了循环的次数
                cur = childrenCur;
            }
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void testCase1() {
        /*
        输入:
         1---2---3---4---5---6--NULL
                 |
                 7---8---9---10--NULL
                     |
                     11--12--NULL

        输出:
        1-2-3-7-8-11-12-9-10-4-5-6-NULL
         */
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node10 = new Node(10, null, null, null);
        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, null, null, null);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;

        flatten(node1);

        System.out.println(node1);
    }
}


