package prakt1.work1;
public class Summa{
    public static void main(String[] args){
        System.out.println("=/____________________________/=");
        int[] massiv=new int[7];//Создание массива на 7 целочисленных элементов
        for(int i=0;i<7;++i){//Цикл заполнения массива рандомными целочисленными значениями
            massiv[i]=(int)(Math.random()*128);//Заполнение встроенной функции Math.random
        }
        for(int i=0;i<7;++i){//Циклассива на 7 целочисленных элементов
            if(i==0){
                System.out.print("==//= Massiv: [_");//Стиль строки первого элемента
            }
            if(i<7-1){
                System.out.print(massiv[i]+"_");//вывод элемента массива
            }else{
                System.out.print(massiv[i]+"_]  =//==");//Стиль строки последнего элемента
            }
        }
        System.out.println("=/____________________________/=");
        System.out.println("=/____________________________/=");
        System.out.println("==//= Summa: [_"+summa(massiv)+"_]  =//==");//Вывод суммы элементов массива
        System.out.println("=/____________________________/=");
    }
    private static int summa(int[] massiv){//Функкция подсчёта суммы элементов массива
        int summa=0;
        for(int i=0;i<7;++i){//Цикл для поэлементного суммирования
            summa+=massiv[i];
        }
        return summa;//Возвращение функцией подсчитанной суммы элементов массива
    }
}