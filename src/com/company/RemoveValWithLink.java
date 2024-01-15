package com.company;

import java.util.ArrayList;
import java.util.List;

public class RemoveValWithLink {



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);


        ListNode listNode = removeElements(node1, 6);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.getNext();
        }

    }


    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //定义一个虚拟节点
        ListNode dummyHead = new ListNode(0);
        //将虚拟节点指向头节点
        dummyHead.next = head;
        //当前节点为虚拟节点，next为当前节点的下一个节点
        ListNode cur = dummyHead, next = cur.next;
        //1,2,6,3,4,5,6
        while (next != null) {
            if (next.val == val) {
                //当前节点的下一个节点为next节点的下一个节点
                cur.next = next.next;
                //next节点向后移
                next = next.next;
            } else {
                //当前节点和下一个节点都向后移
                cur = cur.next;
                next = next.next;
            }
        }
        return dummyHead.next;
    }





}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }
}





