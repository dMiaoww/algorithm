package hot100;

import java.util.*;

/**
 * Created by W
 * Date: 2020-05-13 00:27
 * Description 二叉树的层序遍历
 */
public class Tree102 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List res = new ArrayList();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            List<Integer> tmp = new ArrayList<>();
            //先记录下每层节点数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                //用于存放每层节点的值
                TreeNode node = queue.peek();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queue.remove();
            }
            res.add(tmp);
        }
        return res;
    }
}
