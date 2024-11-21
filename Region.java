public class Region{
    int x1,x2,y1,y2;
    String color;

    public Region(int x1,int y1,int x2,int y2,String color){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }

   
 
    public boolean containsPoint(Point point){
        return point.x>=x1 && point.x<=x2 && point.y>=y1 && point.y<=y2;
    }
}