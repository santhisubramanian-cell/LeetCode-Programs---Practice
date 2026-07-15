package day13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import day10.TreeNode;

public class ZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) level.addLast(node.getVal());
                else level.addFirst(node.getVal());
                if (node.getLeft() != null) q.offer(node.getLeft());
                if (node.getRight() != null) q.offer(node.getRight());
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));
        System.out.println(zigzagLevelOrder(root));
    }
}
