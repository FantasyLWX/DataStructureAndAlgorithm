package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序，不稳定算法，插入排序升级版，跳跃式交换数据</br>
 * </br>
 * 思路：先将整个待排记录序列分割成若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行一次插入排序。</br>
 * </br>
 * 在最佳情况下，时间复杂度为 O(nlogn)</br>
 * </br>
 * 在最差情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 在平均情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 空间复杂度为 O(1)
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.1, 2020-09-04
 *     since   : 1.0, 2020-08-31
 * </pre>
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 1, 3, 2 };
        System.out.println("before : " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("after : " + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int value; // 待插入的值
        int step = length / 2; // 记录每一次跳跃式比较的增量
        int j;
        while (step >= 1) {
            for (int i = step; i < length; i += step) {
                value = arr[i];
                for (j = i; j >= step && arr[j - step] > value; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = value;
            }
            step /= 2; // 缩小跳跃式增量的大小为原来的一半
        }
    }

}