package com.aqiu._3_Array_String;

import java.util.Arrays;

public class _1_P88_MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new _1_P88_MergeSortedArray().new Solution();

    }

    class Solution {
        //使用双指针方法。这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = new int[m];
            if (m != 0) {
                temp = Arrays.copyOf(nums1, m);
            }
            int i = 0, j = 0, k = 0;
            for (; i < m + n && j < m && k < n; i++) {
                if (temp[j] <= nums2[k]) {
                    nums1[i] = temp[j];
                    j++;
                } else {
                    nums1[i] = nums2[k];
                    k++;
                }
            }
            while (j == m && k < n) {
                nums1[i] = nums2[k];
                k++;
                i++;
            }
            while (j < m && k == n) {
                nums1[i] = temp[j];
                j++;
                i++;
            }
        }

        //观察可知，nums1的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 nums1的最后面
        //在把大值放入nums1中时，如果放的是nums1，则nums1空出一个位置;如果放的是nums2，才会占位置，而空出的位置刚好是够nums2用的
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int i = m + n - 1, j = m - 1, k = n - 1;
            for (; i > -1 && j > -1 && k > -1; i--) {
                if (nums1[j] >= nums2[k]) {
                    nums1[i] = nums1[j];
                    j--;
                } else {
                    nums1[i] = nums2[k];
                    k--;
                }
            }
            while (j == -1 && k > -1) {
                nums1[i] = nums2[k];
                k--;
                i--;
            }
            while (j > -1 && k == -1) {
                nums1[i] = nums1[j];
                j--;
                i--;
            }
        }
    }
}
