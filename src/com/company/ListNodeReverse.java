package com.company;

public class ListNodeReverse {

    public static void main(String[] args) {
        Node head1 = new Node("1");
        Node head2 = new Node("2");
        Node head3 = new Node("3");
        Node head4 = new Node("4");

        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head4);

        Node node = reverseNode(head1);

        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }

    }

    /**
     *
     * 尾结点反转的方法
     * 1. 先反转尾结点（reverseHead），指向当前节点(curHead)
     * 2. 当前节点（curHead = head.getNext），指向头结点
     * 3. 递归结束条件,后续节点为null了
     *
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        //空节点的情况下，直接返回这个节点Parcel
        if (head == null || head.getNext() == null) {
            //head.getNext() = null的情况，也就是到最后一个节点的时候，就直接返回最后一个节点，进行递归就好了
            return head;
        }
        //获取到
        //"当前节点" （这里会多次调用，因为下面递归调用执行了reverseNode方法）
        Node curNode = head.getNext();
        //获取反转之后的头节点
        Node reverseNode = reverseNode(curNode);
        //设置当前节点的下一个节点为"head"(这样就实现了反转)
        curNode.setNext(head);
        //这样在反转的时候，遍历到最后一个节点，设置为null的话，那么在函数第一步就能以这个作为flag，结束递归了
        head.setNext(null);
        return reverseNode;
    }


}


// 链表节点 （指针域 + 数据域） （node + data）
class Node {

    public Node(String data) {
        this.data = data;
    }

    //数据域
    private String data;

    //指针域
    private Node next;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
