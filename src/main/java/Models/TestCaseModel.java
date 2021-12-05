package Models;

import java.util.List;

public class TestCaseModel {
    public TestCaseModel(int numberOfNodes, int numberOfPaths, List<NodeModel> nodes){
        NumberOfNodes = numberOfNodes;
        NumberOfPaths = numberOfPaths;
        Nodes = nodes;
    }
    public int NumberOfNodes;
    public int NumberOfPaths;
    public List<NodeModel> Nodes;
}
