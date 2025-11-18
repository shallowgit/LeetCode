package com.aqiu._1_Hash_Table;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Aqiu
 */
public class _9_P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new _9_P128_LongestConsecutiveSequence().new Solution();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        solution.longestConsecutive1(nums);
    }

    class Solution {
        /**
         * 评论里 江不知 的解法
         *
         * 使用哈希表记录边界信息，只维护连续序列的边界信息，而不是记录序列中每个数字的完整信息
         * 1.遍历每个数字，如果该数字不在哈希表中（表示是新序列或可扩展的序列）
         * 2.检查左右邻居：
         *      leftLen：左邻居所在的序列长度
         *      rightLen：右邻居所在的序列长度
         * 3.合并序列：当前数字可能连接左右两个序列，形成更长的连续序列
         * 4.更新边界：只更新新序列的最左端和最右端边界值
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
         *
         * 只从每个连续序列的最小数字（起点）开始计数，避免重复计算
         * 步骤：
         * 1、预处理阶段
         *  将所有数字存入HashSet，实现O(1)时间复杂度的查找
         *  自动去重，确保每个数字只处理一次
         * 2、识别序列起点
         *  如果一个数字的前驱（num-1）存在，那么这个数字肯定不是序列的起点；只有当前驱不存在时，这个数字才可能是某个连续序列的最小值
         * 3、单向扩展计数
         *  从起点开始，向右单向检查连续数字
         *  边计数边删除，确保每个数字只被处理一次
         *  当遇到不连续的数字时停止计数
         *
         * HashSet.remove() 方法详解
         * public boolean remove(Object o)
         * 参数：o 要从集合中移除的元素对象
         * 返回值：boolean 类型。如果集合包含指定元素并且成功移除，返回 true；如果集合不包含指定元素，返回 false
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
         *
         * 以每个数字为中心，向左右两个方向扩展，找出完整的连续序列
         * 1. 预处理阶段
         *  将所有数字存入HashSet，实现O(1)时间复杂度的查找
         *  自动去重，确保每个数字只处理一次
         * 2. 双向扩展计数
         *  对于每个数字，先向左扩展，接着恢复原始位置，再向右扩展
         * 3. 提前终止
         *  当剩余未处理的数字数量已经小于等于当前找到的最大序列长度时，已经不可能找到更长的序列了，提前结束循环
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
                if (hashSet.size() <= maxLen) {
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