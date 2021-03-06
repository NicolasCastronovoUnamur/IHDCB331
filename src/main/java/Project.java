import Models.TestCaseModel;
import Models.TreeNode;

import java.util.*;

public class Project {
    public static void main(String[] args) {
        TestCaseModel testCase = new TestCaseModel(9, 2);

        TreeNode root = new TreeNode(1, null);
        root.IsRoot = true;
        root.Depth = 0;

        TreeNode a = new TreeNode(2, root);
        TreeNode b = new TreeNode(3, root);
        TreeNode c = new TreeNode(4, root);

        TreeNode d = new TreeNode(5, a);
        TreeNode e = new TreeNode(6, a);

        TreeNode f = new TreeNode(7, b);
        TreeNode g = new TreeNode(8, b);
        TreeNode h = new TreeNode(9, b);

        TreeNode[] nodes = {root, a, b, c, d, e, f, g, h};

        nodes = sortByDepth(nodes);

        var pathList = getAllPaths(nodes, testCase.PathSize);

        var paths = getNonCrossingPaths(pathList);

        System.out.println("Numbers of paths : " + paths);
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

    public static List<List<TreeNode>> getAllPaths(TreeNode[] nodeArray, int pathSize) {
        List<List<TreeNode>> pathList = new ArrayList<>();
        for (TreeNode node : nodeArray) {
            List<TreeNode> path = new ArrayList<>();
            TreeNode tempNode = node;
            for (int i = 0; i < pathSize; i++) {
                path.add(tempNode);
                if (tempNode.Depth == 0) {
                    break;
                }
                tempNode = tempNode.Parent;
            }
            if (path.size() == pathSize){
                pathList.add(path);
            }
        }
        return pathList;
    }

    public static int getNonCrossingPaths(List<List<TreeNode>> pathList) {
        int paths = 0;
        boolean isCrossing = false;
        List<Integer> usedNodes = new ArrayList<>();
        for (List<TreeNode> path : pathList) {
            for (TreeNode node : path) {
                if (usedNodes.contains(node.Id)) {
                    isCrossing = true;
                    break;
                }
                else {
                    usedNodes.add(node.Id);
                }
            }
            if (!isCrossing) {
                paths++;
            }
            isCrossing = false;
        }
        return paths;
    }
}