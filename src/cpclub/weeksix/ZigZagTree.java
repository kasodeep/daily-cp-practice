package cpclub.weeksix;

import daily.gfg.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class ZigZagTree {

    static ArrayList<Integer> zigZagTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int flag = 1;
        while (q.size() > 0) {
            int size = q.size();
            ArrayList<Integer> part = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                part.add(temp.data);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }

            if (flag % 2 == 0) Collections.reverse(part);
            ans.addAll(part);
            flag++;
        }
        return ans;
    }
}
