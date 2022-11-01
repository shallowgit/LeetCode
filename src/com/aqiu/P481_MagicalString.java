package com.aqiu;

/**
 * Magical String
 *
 * @author Aqiu
 */
public class P481_MagicalString {
    public static void main(String[] args) {
        Solution solution = new P481_MagicalString().new Solution();

    }

    class Solution {
        public int magicalString(int n) {
            if (n < 4) {
                return 1;
            }
            char[] arr = new char[n];
            arr[0] = '1';
            arr[1] = arr[2] = '2';
            int res = 1;
            int left = 2;
            int right = 3;
            while (right < n) {
                int count = arr[left] - '0';
                int cur = (arr[right - 1] - '0') ^ 3;
                while (count > 0 && right < n) {
                    arr[right] = (char) (cur + '0');
                    if (cur == 1) {
                        res++;
                    }
                    count--;
                    right++;
                }
                left++;
            }
            return res;
        }
        /**
         *  执行耗时:3 ms,击败了94.22% 的Java用户
         * 	内存消耗:39.5 MB,击败了80.53% 的Java用户
         */

        public int magicalString2(int n) {
            if (n < 4) {
                return 1;
            }
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = arr[2] = 2;
            int res = 1;
            int left = 2;
            int right = 3;
            while (right < n) {
                int count = arr[left];
                int cur = arr[right - 1] ^ 3;
                while (count > 0 && right < n) {
                    arr[right] = cur;
                    if (cur == 1) {
                        res++;
                    }
                    count--;
                    right++;
                }
                left++;
            }
            return res;
        }
        /**
         *  执行耗时:2 ms,击败了100.00% 的Java用户
         * 	内存消耗:40.1 MB,击败了68.98% 的Java用户
         */
    }
}