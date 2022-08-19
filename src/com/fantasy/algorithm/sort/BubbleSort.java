package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序，原地排序算法，稳定算法</br>
 * </br>
 * 思路：无序区两两比较，如果前者大于后者则交换两者的位置。每一轮过后，无序区的最大值都会上浮到至末尾，从而形成有序的数列。</br>
 * </br>
 * 在最佳情况下，时间复杂度为 O(n)</br>
 * </br>
 * 在最差情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 在平均情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 空间复杂度为 O(1)
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-29
 *     since   : 1.0, 2020-08-29
 * </pre>
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 3, 2, 1 };
        System.out.println("before : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after : " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化的冒泡排序</br>
     * </br>
     * 1.使用unsortedBorder记录无序区的最后一个，减少比较的次数。</br>
     * </br>
     * 2.使用isSorted来标记某一次遍历是否全部有序，有则直接跳出，减少比较的次数。
     *
     * @param arr 数组
     */
    public static void bubbleSort2(int[] arr) {
        int length = arr.length;
        boolean isSorted = true;
        int lastExchangeIndex = arr.length - 1; // 用于记录最后一个比较交换的位置
        int unsortedBorder = lastExchangeIndex; // 记录无序区的最后一个
        for (int i = 0; i < length; i++) {
            isSorted = true; // 记录这一次遍历是否是全部有序的，有序的话则不用再比较，直接跳出
            for (int j = 0; j < unsortedBorder; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false; // 有交换代表这一次遍历不是全部有序
                    lastExchangeIndex = j; // 更新无序区的边界
                }
            }
            if (isSorted) {
                break;
            }
            unsortedBorder = lastExchangeIndex;
        }
    }

}