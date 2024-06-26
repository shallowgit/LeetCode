package com.aqiu._3_Array_String;

public class _6_P189_RotateArray {
    public static void main(String[] args) {
        Solution solution = new _6_P189_RotateArray().new Solution();
    }

    //数组翻转
    //该方法基于如下的事实：当我们将数组的元素向右移动 k 次后，尾部 k mod n个元素会移动至数组头部，其余元素向后移动 k mod n个位置。
    //该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k mod n个元素就被移至数组头部，
    // 然后我们再翻转 [0,k mod n−1] 区间的元素和 [k mod n,n−1] 区间的元素即能得到最后的答案。
    //
    //我们以 n=7，k=3 为例进行如下展示：
    //操作                                结果
    //原始数组                             1 2 3 4 5 6 7
    //翻转所有元素                          7 6 5 4 3 2 1
    //翻转 [0,k mod n−1] 区间的元素         5 6 7 4 3 2 1
    //翻转 [k mod n−1, n-1] 区间的元素      5 6 7 1 2 3 4
    class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                // 使用异或实现两个整数变量的值进行互换。
                // 异或特点：同一变量与另一变量和其异或值异或等于另一个数，如（a^b）^b=a
                nums[start] = nums[start] ^ nums[end];
                nums[end] = nums[start] ^ nums[end];
                nums[start] = nums[start] ^ nums[end];
                start++;
                end--;
            }
        }
    }
}
