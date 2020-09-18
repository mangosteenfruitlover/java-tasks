package prakt3.work3;
public class BookTest{
    public static void main(String[] args){
        System.out.println("=/____________________________/=");
        String author="Стивен Уильям Хокинг";
        String name="Краткая история времени";
        int year=1988;
        Book book=new Book(author,name,year);
        System.out.println("==//= Author: [_"+book.getAuthor()+"_] =//==");
        System.out.println("==//= Name: [_"+book.getName()+"_] =//==");
        System.out.println("==//= Year: [_"+book.getYear()+"_] =//==");
        System.out.println("=/____________________________/=");
        book.setAuthor("Стивен Уильям Хокинг");
        book.setName("Чёрные дыры и молодые вселенные");
        book.setYear(1993);
        System.out.println("==//= Author: [_"+book.getAuthor()+"_] =//==");
        System.out.println("==//= Name: [_"+book.getName()+"_] =//==");
        System.out.println("==//= Year: [_"+book.getYear()+"_] =//==");
        System.out.println("=/____________________________/=");
    }
}