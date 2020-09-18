package prakt3.work1;
public class Circle{ //Класс Круга
    double Radius;//Свойство Радиуса Круга
    double Square;//Свойство Квадрата Круга
    double Perimeter;//Свойство Периметра Круга
    Circle(double _Radius,double _Square,double _Perimeter){//Конструктор Круга
        getRadius(_Radius);//Вызов Метода обновления Радиуса Круга
        this.Square=_Square;//Установка Площади Круга
        this.Perimeter=_Perimeter;//Установка Периметра Круга
    }
    void getRadius(double _Radius){//Метод обновления Радиуса Круга
        this.Radius=_Radius;//Установка Радиуса Круга
    }
    void matchSquare(){//Метод расчёта Площади Круга
        this.Square=3.14*this.Radius*this.Radius;//Расчёт Площади Круга
    }
    void matchPerimeter(){//Метод расчёта Периметра Круга
        this.Perimeter=2*3.14*this.Radius;//Расчёт Периметра Круга
    }
}