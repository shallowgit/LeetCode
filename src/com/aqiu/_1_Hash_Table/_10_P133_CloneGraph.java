package com.aqiu._1_Hash_Table;

import java.util.*;

/**
 * Clone Graph
 *
 * @author Aqiu
 */
public class _10_P133_CloneGraph {
    public static void main(String[] args) {
        Solution solution = new _10_P133_CloneGraph().new Solution();

    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 参考题解：https://leetcode.cn/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
     */
    class Solution {
        HashMap<Node, Node> hashMap = new HashMap<>();

        /**
         * 深度优先遍历
         */
        public Node cloneGraph1(Node node) {
            if (node == null) {
                return node;
            }
            if (!hashMap.containsKey(node)) {
                // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
                Node newNode = new Node(node.val, new ArrayList());
                // 哈希表存储
                hashMap.put(node, newNode);
                // 遍历该节点的邻居并更新克隆节点的邻居列表
                for (Node neighbor : node.neighbors) {
                    newNode.neighbors.add(cloneGraph1(neighbor));
                }
                return newNode;
            }
            // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
            return hashMap.get(node);
        }

        /**
         * 广度优先遍历
         */
        public Node cloneGraph2(Node node) {
            if (node == null) {
                return node;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            // 克隆第一个节点并存储到哈希表中
            hashMap.put(node, new Node(node.val, new ArrayList<>()));
            // 广度优先搜索
            while (!queue.isEmpty()) {
                // 取出队列的头节点
                Node cur = queue.remove();
                // 遍历该节点的邻居
                for (Node neighbor : cur.neighbors) {
                    if (!hashMap.containsKey(neighbor)) {
                        // 如果没有被访问过，就克隆并存储在哈希表中
                        hashMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        // 将邻居节点加入队列中
                        queue.add(neighbor);
                    }
                    // 更新当前节点的邻居列表
                    hashMap.get(cur).neighbors.add(hashMap.get(neighbor));
                }
            }
            return hashMap.get(node);
        }
    }
}