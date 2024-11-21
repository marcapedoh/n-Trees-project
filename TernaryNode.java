import java.util.ArrayList;
import java.util.List;
public class TernaryNode{
    int x,y;
    String c1,c2,c3;
    List<TernaryNode> children;


    public TernaryNode(int x, int y, String c1, String c2, String c3){
        this.x = x;
        this.y = y;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.children = new ArrayList<>();
    }

    public void addChild(TernaryNode child){
        children.add(child);
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ") - Color1" + c1 + ", Color2 " + c2 + ", Color3 " + c3;
    }
}