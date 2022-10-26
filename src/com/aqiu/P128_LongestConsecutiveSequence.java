package com.aqiu;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Aqiu
 */
public class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();

    }

    class Solution {
        /**
         * 评论里 江不知 的解法
         * @param nums
         * @return
         */
        public int longestConsecutive1(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
            int maxLen = 0;
            for (int num : nums) {
                if (!hashMap.containsKey(num)) {
                    int leftLen = hashMap.getOrDefault(num - 1, 0);
                    int rightLen = hashMap.getOrDefault(num + 1, 0);
                    int nowLength = leftLen + rightLen + 1;
                    hashMap.put(num, nowLength);
                    hashMap.put(num - leftLen, nowLength);
                    hashMap.put(num + rightLen, nowLength);
                    maxLen = Math.max(nowLength, maxLen);
                }
            }
            return maxLen;
        }
        /**
         * 解答成功:
         * 	执行耗时:42 ms,击败了39.14% 的Java用户
         * 	内存消耗:57.6 MB,击败了77.65% 的Java用户
         */


        /**
         * 官方解
         * @param nums
         * @return
         */
        public int longestConsecutive2(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            HashSet<Integer> hashSet = new HashSet<>(nums.length);
            for (int num : nums) {
                hashSet.add(num);
            }
            int maxLen = 0;
            for (int num : nums) {
                if (hashSet.contains(num - 1)) {
                    continue;
                }
                int nowLen = 0;
                while (hashSet.remove(num++)) {
                    nowLen++;
                }
                maxLen = Math.max(nowLen, maxLen);
            }
            return maxLen;
        }
        /**
         * 解答成功:
         * 	执行耗时:17 ms,击败了87.37% 的Java用户
         * 	内存消耗:58.4 MB,击败了53.49% 的Java用户
         */


        /**
         * 评论里 Xdims 与评论区回复相结合
         * @param nums
         * @return
         */
        public int longestConsecutive3(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            HashSet<Integer> hashSet = new HashSet<>(nums.length);
            for (int num : nums) {
                hashSet.add(num);
            }
            int maxLen = 0;
            for (int num : nums) {
                int nowLen = 1;
                int temp = num;
                while (hashSet.remove(--num)) {
                    nowLen++;
                }
                num = temp;
                while (hashSet.remove(++num)) {
                    nowLen++;
                }
                maxLen = Math.max(nowLen, maxLen);
                if (hashSet.size() < maxLen) {
                    break;
                }
            }
            return maxLen;
        }
        /**
         * 解答成功:
         * 	执行耗时:16 ms,击败了88.69% 的Java用户
         * 	内存消耗:57.5 MB,击败了78.45% 的Java用户
         */
    }
}