package com.leonsh.java.code.leetcode;

import com.leonsh.java.code.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * QuickSort
 *
 * @author leonsh
 * @date 2022-03-09 18:18
 **/
@Slf4j
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = CommonUtil.generateSortedArray(10);
        CommonUtil.shuffle(nums);
        log.info("input: {}", nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.println();
        log.info("result: {}", nums);
    }

    public static void quickSort(int[] nums, int left, int right) {
        log.info("result: {}", nums);
        if (left >= right) {
            return;
        }

        swap(nums, left, (right + left) / 2);
        int mid = nums[left];

        int slow = left;
        int fast = right;

        while (slow < fast) {
            while (slow < fast && nums[slow] <= mid) {
                slow += 1;
            }

            while (slow < fast && nums[fast] > mid) {
                fast -= 1;
            }
            swap(nums, slow, fast);
        }


        quickSort(nums, left, slow - 1);
        quickSort(nums, slow, right);

    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
