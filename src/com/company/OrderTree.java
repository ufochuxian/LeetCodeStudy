package com.company;


import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树
 *
 * 递归系列算法，通用的方法论
 * 1. 确定函数的参数和返回值
 * 2. 确定单步递归函数踢
 * 3. 确定递归函数的结束条件
 *
 * 二叉树的讲解文章
 * https://blog.csdn.net/My_Jobs/article/details/43451187
 */

public class OrderTree {

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode("4", null, null);
        TreeNode node5 = new TreeNode("5", null, null);
        TreeNode node6 = new TreeNode("6", null, null);
        TreeNode node7 = new TreeNode("7", null, null);
        TreeNode node1 = new TreeNode("1", node6, node7);
        TreeNode node2 = new TreeNode("2", node4, node5);
        TreeNode node3 = new TreeNode("3", node2, node1);

        List<String> preStrings = preOrder(node3);
        System.out.println("先序遍历: " + preStrings);


        nonRecursionPreOrder(node3);

        List<String> middleStrings = middleOrder(node3);
        System.out.println("中序遍历: " + middleStrings);

        nonRecursionMiddleOrder(node3);

    }

    //二叉树的中序遍历 左 根 右
    public static List<String> middleOrder(TreeNode node) {
        //存放遍历后的结果
        List<String> result = new ArrayList<>();
        middleOrderExecute(node, result);
        return result;
    }

    //二叉树的先序遍历  根 左 右
    public static List<String> preOrder(TreeNode node) {
        //存放遍历后的结果
        List<String> result = new ArrayList<>();
        preOrderExecute(node, result);
        return result;
    }

    // 前序遍历的非递归实现
    //https://blog.csdn.net/My_Jobs/article/details/43451187
    public static void nonRecursionPreOrder(TreeNode node) {
        // 1. 打印出当前传入的节点的值
        // 2. 遍历当前节点是否有左节点，有的话直接打印值，没有的话，要获取当前节点的右节点(这里可以使用栈，方便访问右节点)。设置为当前节点，重复步骤
        //
        //存放遍历后的结果
        List<String> result = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode=  node;
        while (curNode != null || !stack.isEmpty()) {
            if(curNode != null) {
                result.add(curNode.val);
                //将当前节点压入栈中（这边主要是利用了栈可以弹出的特性，方便当当前节点的left节点没有了子节点的时候，方便的取到右节点）
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                // 将栈中的节点弹出来,这样就能方便的找到右节点了，从而可以设置为当前节点，继续进行递归
                TreeNode popNode = stack.pop();
                //并且将当前节点的右节点,设置为当前节点，继续进行递归
                curNode = popNode.right;
            }
        }

        System.out.println("非递归实现前序遍历: " + result);

    }

    // 中序遍历的非递归实现
    //https://blog.csdn.net/My_Jobs/article/details/43451187
    public static void nonRecursionMiddleOrder(TreeNode node) {
        // 1. 打印出当前传入的节点的值
        // 2. 遍历当前节点是否有左节点，有的话直接打印值，没有的话，要获取当前节点的右节点(这里可以使用栈，方便访问右节点)。设置为当前节点，重复步骤
        //
        //存放遍历后的结果
        List<String> result = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode=  node;
        while (curNode != null || !stack.isEmpty()) {
            if(curNode != null) {
                //将当前节点压入栈中（这边主要是利用了栈可以弹出的特性，方便当当前节点的left节点没有了子节点的时候，方便的取到右节点）
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                // 将栈中的节点弹出来,这样就能方便的找到右节点了，从而可以设置为当前节点，继续进行递归
                TreeNode popNode = stack.pop();
                // 中序遍历的话 左 跟 右的顺序，那么只需要将存储值的顺序，放置到弹出栈的时候（出栈的一定是左节点），就可以了
                result.add(curNode.val);
                //并且将当前节点的右节点,设置为当前节点，继续进行递归
                curNode = popNode.right;
            }
        }

        System.out.println("非递归实现中序遍历: " + result);

    }


    // 递归中序遍历
    private static void middleOrderExecute(TreeNode node, List<String> result) {
        if (node == null) {
            //遍历到没有子节点了
            return;
        }
        middleOrderExecute(node.left, result);
        result.add(node.val);
        middleOrderExecute(node.right, result);
    }

    //先序递归遍历 根 左 右
    private static void preOrderExecute(TreeNode node,List<String> result) {
        if(node == null) {
            return;
        }
        result.add(node.val);
        preOrderExecute(node.left,result);
        preOrderExecute(node.right,result);
    }

}


class TreeNode {

    public String val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }

    public TreeNode(String val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
