import java.util.List;
import java.io.File;

public class Main{
    public static void main(String[] args){


        QuadTree tree=new QuadTree(1500);

        List<Point> points=List.of(
            new Point(600,500,"Red","Green","Yellow","Blue"),
            new Point(900,400,"Yellow","Brown","Navy","Blue"),
            new Point(800,300,"Green","Red","Blue","Yellow"),
            new Point(850,350,"Red","Yellow","Red","Yellow"),
            new Point(540,120,"Blue","Red","Yellow","Green")
        );

        tree.buildQTree(points);

        System.out.println("Tree created successfully!");

        TernaryNode mainTerNode = new TernaryNode(800,800, "Red", "Yellow", "Green");
        TernaryTree ternarytree = new TernaryTree(mainTerNode);
        ternarytree.divideNode(mainTerNode,300,300, "Red", "Purple", "Green");
        ternarytree.divideNode(mainTerNode,250,250, "Yellow", "Blue", "Pink");
        ternarytree.divideNode(mainTerNode,250,250, "Red", "Grey", "Orange");
        String projectDir = System.getProperty("user.dir");
        String imagePath = projectDir + File.separator + "QuadTree.png";

        tree.toImage(imagePath);
    }
}