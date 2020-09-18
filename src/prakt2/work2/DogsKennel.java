package prakt2.work2;
import java.util.ArrayList;
public class DogsKennel{
    public static void main(String[] args){
        ArrayList<Dog> dogArray=new ArrayList<>();//Создание Массива собачек
        String Nickname;
        int Summer;
        //1
        Nickname="Bobik";
        System.out.println("=/____________________________/=");
        System.out.println("==/= Nickname= [_"+Nickname+"_] =/==");
        Summer=5;
        System.out.println("==/= Summer= [_"+Summer+"_] =/==");
        System.out.println("=/____________________________/=");
        dogArray.add(new Dog(Nickname,Summer));//Добавление Бобика в Массив Питомника собачек
        //2
        Nickname="Scharik";
        System.out.println("==/= Nickname= [_"+Nickname+"_] =/==");
        Summer=9;
        System.out.println("==/= Summer= [_"+Summer+"_] =/==");
        dogArray.add(new Dog(Nickname,Summer));//Добавление Шарика в Массив Питомника собачек
        //3
        Nickname="Tusik";
        System.out.println("=/____________________________/=");
        System.out.println("==/= Nickname= [_"+Nickname+"_] =/==");
        Summer=4;
        System.out.println("==/= Summer= [_"+Summer+"_] =/==");
        System.out.println("=/____________________________/=");
        dogArray.add(new Dog(Nickname,Summer));//Добавление Тузика в Массив Питомника собачек
        for(Dog element: dogArray){
            System.out.println(element.toString());//Вывод данных о каждой собачке из Массива Питомника собачек
        }
        System.out.println("=/____________________________/=");
    }
}