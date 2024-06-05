package com.aqiu._3_Array_String;

import java.util.Arrays;

public class _2_P27_RemoveElement {
    public static void main(String[] args) {
        Solution solution = new _2_P27_RemoveElement().new Solution();
    }

    //如果左指针 left指向的元素等于 val，此时将右指针 right指向的元素复制到左指针 left的位置，然后右指针 right左移一位。
    //如果赋值过来的元素恰好也等于 val，可以继续把右指针 right指向的元素的值赋值过来（左指针 left指向的等于 val的元素的位置继续被覆盖），
    //直到左指针指向的元素的值不等于 val为止。
    //当左指针 left和右指针 right重合的时候，左右指针遍历完数组中所有的元素
    class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0, right = nums.length;
            while (left < right) {
                if (nums[left] == val) {
                    nums[left] = nums[right - 1];
                    right--;
                } else {
                    left++;
                }
            }
            return left;
        }
    }
}
