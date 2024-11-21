
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class QuadTree{
    QuadTreeNode mainNode;

    public QuadTree(int size){
        Region initialRegion = new Region(0,0,size,size,"Grey");
        mainNode= new QuadTreeNode(initialRegion);
    }

    public void divideRegion(QuadTreeNode node,Point point){
        if(!node.isleaf()){
            return;
        }
        Region region=node.region;
        node.no=new QuadTreeNode(new Region(region.x1,(region.x1+region.x2)/2,(region.y1+region.y2)/2,region.y2,point.c1));
        node.ne=new QuadTreeNode(new Region((region.x1+region.x2)/2,region.x2,(region.y1+region.y2)/2,region.y2,point.c2));
        node.so=new QuadTreeNode(new Region((region.x1+region.x2)/2,region.x2,region.y1,(region.y1+region.y2)/2,point.c3));
        node.se=new QuadTreeNode(new Region(region.x1,(region.x1+region.x2)/2,region.y1,(region.y1+region.y2)/2,point.c4));
    }

    public QuadTreeNode searchQTree(Point point){
        return searchQtreeRecursive(mainNode,point);
    }

    private QuadTreeNode searchQtreeRecursive(QuadTreeNode node, Point point){
        if(node.isleaf() && node.region.containsPoint(point)){
            return node;
           
        }else{
            if(node.no!=null && node.no.region.containsPoint(point)) searchQtreeRecursive(node.no,point);
            else if(node.ne!=null && node.ne.region.containsPoint(point)) searchQtreeRecursive(node.ne,point);
            else if(node.so!=null && node.so.region.containsPoint(point)) searchQtreeRecursive(node.so,point);
            else if(node.se!=null && node.se.region.containsPoint(point)) searchQtreeRecursive(node.se,point);
            return node;
        }
    }

    public void addQTree(QuadTreeNode node,Point point) {
         divideRegion(node,point);
    }

    public void buildQTree(List<Point> points) {
        for(Point point : points){
            QuadTreeNode node= searchQTree(point);
            if(node!=null){
                addQTree(node,point);
            }
        }
    }

    public void toImage(String fileNamePath){
        int width=mainNode.region.x2;
        int height=mainNode.region.y2;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        fillImageWithRegions(mainNode,image);

        try{
            ImageIO.write(image, "png", new File(fileNamePath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void fillImageWithRegions(QuadTreeNode node, BufferedImage image){
        if(node.isleaf()){
            Color color=getColor(node.region.color);
            for(int i=node.region.x1;i<node.region.x2;i++){
                for(int j=node.region.y1;j<node.region.y2;j++){
                    image.setRGB(i,j,color.getRGB());
                }
            }
        }else{
            fillImageWithRegions(node.no, image);
        fillImageWithRegions(node.ne, image);
        fillImageWithRegions(node.so, image);
        fillImageWithRegions(node.se, image);
        }
    }

    private Color getColor(String color){
        if(color.equalsIgnoreCase("grey")) return Color.GRAY;
        else if(color.equalsIgnoreCase("red")) return Color.RED;
        else if(color.equalsIgnoreCase("blue")) return Color.BLUE;
        else if(color.equalsIgnoreCase("green")) return Color.GREEN;
        else if(color.equalsIgnoreCase("yellow")) return Color.YELLOW;
        else if(color.equalsIgnoreCase("orange")) return Color.ORANGE;
        else if(color.equalsIgnoreCase("purple")) return Color.MAGENTA;
        else if(color.equalsIgnoreCase("cyan")) return Color.CYAN;
        else if(color.equalsIgnoreCase("pink")) return Color.PINK;
        else if(color.equalsIgnoreCase("Purple")) return Color.MAGENTA;
        else return Color.WHITE;
    }
}