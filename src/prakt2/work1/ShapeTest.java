package prakt2.work1;
public class ShapeTest{
    public static void main(String[] args){
        Shape triangle=new Shape("triangle",16,24);
        System.out.println(triangle.ShapeLine());
        triangle.shape="trigon";
        triangle.P=17;
        triangle.S=23;
        System.out.println("==/=_______New:_______=/==");
        System.out.println(triangle.ShapeLine());
    }
}