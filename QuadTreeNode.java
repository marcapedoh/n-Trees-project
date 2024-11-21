public class QuadTreeNode{
    Region region;
    QuadTreeNode no,ne,so,se;

    public QuadTreeNode(Region region){
        this.region= region;
        this.no=null;
        this.ne=null;
        this.so=null;
        this.se=null;
    }

    public boolean isleaf(){
        return no==null && ne==null && so==null && se==null;   
    }
}