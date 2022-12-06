package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 以下代码例子的树的结构
 * <p>
 * 3
 * 2        1
 * 4    5    6   7
 */

public class DeepestBinaryTree {

    /**
     * 深度优先搜索二叉树
     *
     * @param args
     */

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode("4", null, null);
        TreeNode node5 = new TreeNode("5", null, null);
        TreeNode node6 = new TreeNode("6", null, null);
        TreeNode node7 = new TreeNode("7", null, null);
        TreeNode node1 = new TreeNode("1", node6, node7);
        TreeNode node2 = new TreeNode("2", node4, node5);
        TreeNode node3 = new TreeNode("3", node2, node1);

//        System.out.println(findDeepest(node3));

        findDeepestByStack(node3);
//        findWidthByQueue(node3);

    }


    /**
     * 深度优先遍历搜索的思路
     * <p>
     * 1. 先找出 左子树的最大深度 （左子树又可以分为左右子树，继续递归）
     * 2. 再找出 右子树的最大深度 （右子树又可以分为左右子树，继续递归）
     * 3. 比较找出的两个
     *
     * @param root
     * @return
     */
    public static int findDeepest(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = findDeepest(root.left);
            int rightHeight = findDeepest(root.right);
            // 这里没执行一次递归过程，就进行 + 1，操作
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 深度递归使用栈的方式实现
     * <p>
     * 输出结果： 3 2 4 5 1 6 7
     */
    public static void findDeepestByStack(TreeNode root) {
        if (root == null) {
            System.out.println("空节点");
            return;
        }
        //定义一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //弹出栈元素
            TreeNode topNode = stack.pop();
            System.out.print(topNode.val + " ");
            //因为栈这种数据结构的特性是先进后出，所以这里需要先放入右边的子节点
            if (topNode != null) {
                if (topNode.right != null) {
                    stack.push(topNode.right);
                }
                if (topNode.left != null) {
                    stack.push(topNode.left);
                }
            }
        }

    }


    /**
     * 广度搜索二叉树 (采用队列，先进先出的特性来实现)
     * <p>
     * <p>
     * 输出结果： 3 2 1 4 5 6 7
     */

    public static void findWidthByQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode topNode = queue.poll();
            System.out.print(topNode.val + " ");
            if (topNode != null) {
                //因为是层次广度遍历，队列先进先出的特性，所以先左节点
                if (topNode.left != null) {
                    queue.add(topNode.left);
                }

                if (topNode.right != null) {
                    queue.add(topNode.right);
                }
            }
        }
    }

}
