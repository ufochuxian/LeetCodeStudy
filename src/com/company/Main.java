package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static int UNFIND = -1;

    public static void main(String[] args) {
        // write your code here

        int[] array2 = new int[]{28, 30, 10, 15, 14, 8, 90};

//        sort(array2);

        bubbleSort(array2);
    }


    //1. 选择排序
    public static int selectionSort(int[] array) {
        if (array == null || array.length < 0) {
            return UNFIND;
        }

        int minPos = 0;
        int temp;
        for (int i = 0; i < array.length; i++) {
            //进行数组长度额次数的轮次
            minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    //1. 更换当前最小变量的位置
                    minPos = j;
                }
            }
            //2. 进行交换
            temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;

        }
        printArray(array);
        return minPos;
    }

    private static void printArray(int[] array) {
        for (int x = 0; x <= array.length - 1; x++) {
            System.out.print(array[x] + " ");
        }
        System.out.println();
    }


    //选择排序
    public static void sort(int[] array) {
        int minPos;
        for (int i = 0; i < array.length; i++) {
            minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            //swap
            int temp = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }

        printArray(array);

    }

    // 位置置换
    private static void swap(int[] array, int minPos, int i) {
        //swap
        int temp = array[minPos];
        array[minPos] = array[i];
        array[i] = temp;
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        //int[] array2 = new int[]{28, 30, 10, 15, 14, 8, 90};
        System.out.println("原始数组----------");
        printArray(array);
        System.out.println("原始数组----------");

        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("i:" + i);
            for (int j = 0; j < array.length - 1; j++) {
                System.out.print("j:" + j + " ");
                int value = array[j];
                int nextValue = array[j + 1];
                if (value > nextValue) {
                    swap(array, j, j + 1);
                }
            }
            System.out.println("");
            System.out.println("i:" + i + " 交换后的数组:");
            printArray(array);
            System.out.println("--------");
        }
        printArray(array);
    }

}
