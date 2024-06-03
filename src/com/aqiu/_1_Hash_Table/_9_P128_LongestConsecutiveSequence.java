package com.aqiu._1_Hash_Table;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Aqiu
 */
public class _9_P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new _9_P128_LongestConsecutiveSequence().new Solution();

    }

    //HashSet中的remove()方法用于从集合中删除指定的元素。这个方法带入一个参数，即要删除的元素。
    //如果集合中存在这个元素，那么它将会被删除。如果集合中不存在这个元素，则没有任何操作，也不会报错。这个方法返回一个Boolean值，表示是否成功删除了元素。
    class Solution {
        /**
         * 官方解
         */
        public int longestConsecutive1(int[] nums) {
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
         */
        //记录下有没有相邻的元素，比如遍历到100这个元素，我们需要查看[99, 101]这两个元素在不在序列中，这样去更新最大长度
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
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int nowLen = 1;
                int temp = num;
                while (hashSet.remove(--num)) {
                    nowLen++;
                }
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
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

        public int longestConsecutive3(int[] nums) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                hashSet.add(num);
            }
            int maxLength = 0;
            for (int num : hashSet) {
                if (!hashSet.contains(num - 1)) {
                    int curLength = 1;
                    int curNum = num+1;
                    while (hashSet.contains(curNum++)) {
                        curLength++;
                    }
                    if (curLength > maxLength) {
                        maxLength = curLength;
                    }
                }
            }
            return maxLength;
        }
    }
}