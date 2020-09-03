package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序，稳定算法，又称直接插入排序</br>
 * </br>
 * 思路：从第二个元素开始，每次与前面的元素比较寻找插入的位置，每插入一个数，都会使前面的有序区增加一个数。</br>
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
 *     version : 1.1, 2020-09-03
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
            for (j = i; j >= 1 && arr[j - 1] > value; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = value;
        }
    }

}