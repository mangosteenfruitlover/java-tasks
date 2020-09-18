package prakt3.work1;
public class CircleTest{
    public static void main(String[] args){
        Circle circle=new Circle(3,28,19);//Создание Объекта Круг
        System.out.println("=/____________________________/=");
        System.out.println("==//= Radius: [_"+circle.Radius+"_]  =//==");
        System.out.println("==//= Square: [_"+circle.Square+"_]  =//==");
        System.out.println("==//= Perimeter: [_"+circle.Perimeter+"_]  =//==");
        System.out.println("=/____________________________/=");
        circle.getRadius(6);//Вызов Метода обновления Радиуса Круга
        circle.matchSquare();//Вызов Метода расчёта Площади Круга
        circle.matchPerimeter();//Вызов Метода расчёта Периметра Круга
        System.out.println("==//= Radius: [_"+circle.Radius+"_]  =//==");
        System.out.println("==//= Square: [_"+circle.Square+"_]  =//==");
        System.out.println("==//= Perimeter: [_"+circle.Perimeter+"_]  =//==");
        System.out.println("=/____________________________/=");
    }
}
