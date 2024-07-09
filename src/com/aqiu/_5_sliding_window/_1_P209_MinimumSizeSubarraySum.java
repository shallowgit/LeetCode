package com.aqiu._5_sliding_window;

public class _1_P209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new _1_P209_MinimumSizeSubarraySum().new Solution();
        int[] ints = new int[]{2, 3, 1, 2, 4, 3};
        solution.minSubArrayLen(7, ints);
    }

    //定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，维护变量 sum 存储子数组中的元素和（即从 nums[start] 到 nums[end] 的元素和）。
    //初始状态下，start 和 end 都指向下标 0，sum 的值为 0。
    //每一轮迭代，将 nums[end] 加到 sum，如果 sum≥s，则更新子数组的最小长度（此时子数组的长度是 end−start+1），
    //然后将 nums[start] 从 sum 中减去并将 start 右移，直到 sum<s，在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end 右移
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int start = 0, end = 0;
            int sum = 0, minLen = Integer.MAX_VALUE;
            while (end < nums.length) {
                sum += nums[end];
                while (sum >= target) {
                    if (end - start + 1 < minLen) {
                        minLen = end - start + 1;
                    }
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}