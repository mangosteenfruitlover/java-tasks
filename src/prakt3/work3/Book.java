package prakt3.work3;
public class Book{//Класс Книги
    String author;//Автор- Свойства Книги
    String name;//Название- Свойства Книги
    int year;//Год написания- Свойства Книги
    public Book(String author,String name,int year){//Конструктор Книги
        this.author=author;//Обновление Автора Книги
        this.name=name;//Обновление Названия Книги
        this.year=year;//Обновление Года написания Книги
    }
    public String getAuthor(){//Метод получения Автора Книги
        return author;
    }
    public String getName(){//Метод получения Названия Книги
        return name;
    }
    public int getYear(){//Метод получения Года написания Книги
        return year;
    }
    public void setAuthor(String author){//Метод установки Автора Книги
        this.author=author;
    }
    public void setName(String name){//Метод установки Названия Книги
        this.name=name;
    }
    public void setYear(int year){//Метод установки Года написания Книги
        this.year=year;
    }
}