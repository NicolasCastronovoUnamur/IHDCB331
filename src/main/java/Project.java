import Models.TestCaseModel;
import Models.TreeNode;

public class Project {
    public static void main(String[] args) {
        TestCaseModel testCase = new TestCaseModel(9, 3);

        TreeNode root = new TreeNode(1, null);
        root.IsRoot = true;
        root.Depth = 0;

        TreeNode a = new TreeNode(2, root);
        TreeNode b = new TreeNode(3, root);
        TreeNode c = new TreeNode(4, root);

        TreeNode d = new TreeNode(5, a);
        TreeNode e = new TreeNode(6, a);

        TreeNode f = new TreeNode(2, b);
        TreeNode g = new TreeNode(3, b);
        TreeNode h = new TreeNode(4, b);

        TreeNode[] nodes = {root, a, b, c, d, e, f, g, h};

        for (TreeNode node : nodes) {
            System.out.println(node.Depth);
        }

        System.out.println("...");

        nodes = sortByDepth(nodes);


        for (TreeNode node : nodes) {
            System.out.println(node.Depth);
        }
    }

    public static TreeNode[] sortByDepth(TreeNode[] nodeArray) {
        TreeNode temp;
        for (int i = 0; i < nodeArray.length; i++) {
            for (int j = i+1; j < nodeArray.length; j++) {
                if (nodeArray[i].Depth < nodeArray[j].Depth) {
                    temp = nodeArray[i];
                    nodeArray[i] = nodeArray[j];
                    nodeArray[j] = temp;
                }
            }
        }
        return nodeArray;
    }
}