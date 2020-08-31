package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序，不稳定算法，插入排序升级版，跳跃式交换数据</br>
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
 *     version : 1.0, 2020-08-31
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
        while (step >= 1) {
            for (int i = step; i < length; i += step) {
                value = arr[i];
                int j = i;
                // 注意点，与插入排序不同的是这里要">="，因为step最小为1
                while (j >= step && arr[j - step] > value) {
                    arr[j] = arr[j - step];
                    j -= step;
                }
                arr[j] = value;
            }
            step /= 2; // 缩小跳跃式增量的大小为原来的一半
        }
    }

}