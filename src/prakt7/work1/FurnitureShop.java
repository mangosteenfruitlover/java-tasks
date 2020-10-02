package prakt7.work1;

public class FurnitureShop {
    //String furniture_name = "Furniture";
    static Table table = new Table();
    static Stool stool = new Stool();
    static Chair chair = new Chair();

    public FurnitureShop() {

    }

    public static Table getTable(){
        return(table);
    }

    public static Stool getStool(){
        return(stool);
    }

    public static Chair getChair(){
        return(chair);
    }
}
