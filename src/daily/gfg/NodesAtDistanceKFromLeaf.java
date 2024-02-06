package daily.gfg;

import java.util.Arrays;

public class NodesAtDistanceKFromLeaf {

    static int ctr;
    static boolean[] visited = new boolean[100001];

    public static void kDistantFromLeafUtil(TreeNode root, int level, int k) {
        if (root == null) return;
        visited[level] = false;

        if (root.left == null && root.right == null && level - k >= 0 && !visited[level - k]) {
            ctr++;
            visited[level - k] = true;
            return;
        }

        kDistantFromLeafUtil(root.left, level, k);
        kDistantFromLeafUtil(root.right, level, k);
    }

    public static int printKDistantFromLeaf(TreeNode root, int k) {
        ctr = 0;
        Arrays.fill(visited, false);

        kDistantFromLeafUtil(root, 0, k);
        return ctr;
    }
}
