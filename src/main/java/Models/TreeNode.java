package Models;

import java.util.Comparator;
import java.util.List;

public class TreeNode {
    public int Id;
    public TreeNode Parent;
    public boolean IsRoot;
    public int Depth;

    public TreeNode(int id, TreeNode parent) {
        Id = id;
        Parent = parent;
        if (Parent != null) {
            Depth = Parent.Depth + 1;
        }
        IsRoot = false;
    }
}
