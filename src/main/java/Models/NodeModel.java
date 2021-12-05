package Models;

public class NodeModel{
    public NodeModel(int id, int parent, int child){
        Id = id;
        Parent = parent;
        Child = child;
    }
    public int Id;
    public int Parent;
    public int Child;
}