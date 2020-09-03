package com.fantasy.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序，不稳定算法</br>
 * </br>
 * 思路：取一个记录作为基准元素，经过一趟排序将整段序列分为两个部分，使得左侧都小于基准元素、右侧都大于基准元素；</br>
 * 再对这两部分继续进行排序，使整个序列达到有序。</br>
 * </br>
 * 在最佳情况下，时间复杂度为 O(nlogn)</br>
 * </br>
 * 在最差情况下，时间复杂度为 O(n^2)</br>
 * </br>
 * 在平均情况下，时间复杂度为 O(nlogn)</br>
 * </br>
 * 空间复杂度为 O(1)
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-24
 *     since   : 1.0, 2020-08-24
 * </pre>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 4, 5 };
        System.out.println("before quick sort: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("after quick sort: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // 得到基准元素位置，基准元素左边的数据小于基准元素，基准元素右边的数据大于基准元素
            int pivotIndex = partition(arr, startIndex, endIndex);
            // 根据基准元素，分成两部分递归排序
            quickSort(arr, startIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, endIndex);
        }
    }

    /**
     * 使用“指针交换法”来对数组进行分割，并得到基准元素的位置
     *
     * @param arr        数组
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     * @return 基准元素的下标
     */
    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针比较并左移
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // pivot和指针重合点交换
        int temp = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = temp;

        return left;
    }

}