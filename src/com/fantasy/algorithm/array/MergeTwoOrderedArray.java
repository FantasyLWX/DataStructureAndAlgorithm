package com.fantasy.algorithm.array;

import java.util.Arrays;

/**
 * 将两个有序数组合并为一个有序数组
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-01
 *     since   : 1.0, 2020-07-01
 * </pre>
 */
public class MergeTwoOrderedArray {

    public static void main(String[] args) {
        int[] arr1 = { 1, 6, 8, 9 };
        int[] arr2 = { 2, 2, 7, 8 };
        int[] arr = mergeTwoOrderedArray(arr1, arr2);
        System.out.println(Arrays.toString(arr)); // [1, 2, 2, 6, 7, 8, 8, 9]
    }

    public static int[] mergeTwoOrderedArray(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;

        int n = length1 + length2;
        int[] arr = new int[n];

        int i = 0;
        int j = 0;

        for (int k = 0; k < n; k++) {
            if (i >= length1) {
                arr[k] = arr2[j++];
            } else if (j >= length2) {
                arr[k] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                arr[k] = arr2[j++];
            } else {
                arr[k] = arr1[i++];
            }
        }

        return arr;
    }

}