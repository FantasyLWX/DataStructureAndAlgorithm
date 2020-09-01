package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序，又称直接插入排序，稳定算法</br>
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
 *     version : 1.0, 2020-08-31
 *     since   : 1.0, 2020-08-31
 * </pre>
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 1, 3, 2 };
        System.out.println("before : " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("after : " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int length = arr.length;
        int value; // 待插入的值
        int j;
        for (int i = 1; i < length; i++) {
            value = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > value; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 插入排序的另一种实现
     *
     * @param arr 数组
     */
    public static void insertionSort2(int[] arr) {
        int length = arr.length;
        int value; // 待插入的值
        for (int i = 1; i < length; i++) {
            value = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = value;
        }
    }

}