package com.aqiu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49_GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Arrays.sort(strs);
            List<String> strsList = new ArrayList<>();
            for (String str : strs) {
                strsList.add(str);
            }
            List<List<String>> list = new ArrayList<>();
            while (!strsList.isEmpty()) {
                List<String> nextList = new ArrayList<>();
                for (String s : strsList) {
                    nextList.add(s);
                }
                String temp = strsList.get(0);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(temp);
                int index = 0;
                for (int j = 1; j < strsList.size() && strsList.get(j).length() == temp.length(); j++) {
                    if (!strsList.get(0) .equals("")) {
                        for (int k = 0; k < temp.length(); k++) {
                            if (!strsList.get(j).contains(temp.charAt(k) + "")) {
                                break;
                            }
                            if (k == temp.length() - 1) {
                                arrayList.add(strsList.get(j));
                                nextList.remove(j - index);
                                index++;
                            }
                        }
                    } else {
                        if (strsList.get(j).equals("")) {
                            arrayList.add(strsList.get(j));
                            nextList.remove(j - index);
                            index++;
                        }
                    }
                }
                nextList.remove(0);
                list.add(arrayList);
                strsList = nextList;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}