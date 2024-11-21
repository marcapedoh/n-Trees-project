public class TernaryTree{
    TernaryNode mainNode; 
    
    public TernaryTree(TernaryNode mainNode) {
        this.mainNode = mainNode;
    }

    public void divideNode(TernaryNode node,int newX,int newY,String c1,String c2,String c3) {
        TernaryNode child = new TernaryNode(newX,newY,c1,c2,c3);
        mainNode.addChild(child);
    }
}