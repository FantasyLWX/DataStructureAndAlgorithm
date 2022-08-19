package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序，原地排序算法，不稳定算法</br>
 * </br>
 * 思路：选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。</br>
 * </br>
 * 在最佳情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 在最差情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 在平均情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 空间复杂度为 O(1)
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-09-02
 *     since   : 1.0, 2020-09-02
 * </pre>
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 1, 3, 2 };
        System.out.println("before : " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("after : " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        int indexMin;
        for (int i = 0; i < length - 1; i++) {
            indexMin = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int temp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }
        }
    }

}