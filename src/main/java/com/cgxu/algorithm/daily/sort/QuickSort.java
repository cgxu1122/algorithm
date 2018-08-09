package com.cgxu.algorithm.daily.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 类描述:
 *
 * @author: chenggangxu@sohu-inc.com
 * @date: 2018/8/9 下午1:55
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = new int[]{8, 3, 7, 4, 6, 10};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));

    }


    public static void quickSort(int[] array) {
        if (Objects.isNull(array)) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (Objects.isNull(array) || low >= high) {
            return;
        }

        int axis = partition(array, low, high);
        quickSort(array, low, axis - 1);
        quickSort(array, axis + 1, high);


    }


    private static int partition(int[] array, int low, int high) {
        int keyVal = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            //从左往右 查找比中轴小的元素值
            while (array[i] <= keyVal && i < high) {
                i++;
            }
            //从右往左 查找比中轴大的元素值
            while (array[j] > keyVal && j > low) {
                j--;
            }
            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
        if (j != low) {
            array[j] = array[low] ^ array[j];
            array[low] = array[low] ^ array[j];
            array[j] = array[low] ^ array[j];
        }

        return j;
    }

}
