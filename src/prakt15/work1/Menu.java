package prakt15.work1;
public class Menu{
    public static void main(String[] args){
        Menu menu=new Menu();
        List_Functions list_functions=new List_Functions();
        menu.menu(list_functions);
    }
    public void menu(List_Functions list_functions){
        int condition=9;
        while(condition!=0){
            if(condition==1){
                list_functions.adding(-1);
            }else if(condition==2){
                list_functions.deleting();
            }else if(condition==3){
                list_functions.finding_by_value();
            }else if(condition==4){
                list_functions.finding_by_key();
            }else if(condition==5){
                list_functions.finding_max();
            }else if(condition==6){
                list_functions.finding_min();
            }else if(condition==7){
                list_functions.finding_Middle();
            }else if(condition==8){
                list_functions.displaying();
            }else if(condition==9){
                System.out.println("|9|           Starting OPENing Menu           |9|");
                System.out.println("|/| Press '1' for start                ADDing |/|");
                System.out.println("|/| Press '2' for start              DELETing |/|");
                System.out.println("|/| Press '3' for start      FINDing by Value |/|");
                System.out.println("|/| Press '4' for start        FINDing by Key |/|");
                System.out.println("|/| Press '5' for start     FINDing Max Value |/|");
                System.out.println("|/| Press '6' for start     FINDing Min Value |/|");
                System.out.println("|/| Press '7' for start FINDing Average Value |/|");
                System.out.println("|/| Press '8' for start            DISPLAYing |/|");
                System.out.println("|/| Press '9' for start        OPENing   Menu |/|");
                System.out.println("|/| Press '0' for END                         |/|");
            }
            System.out.println("|/|... ");
            condition=list_functions.scanner.nextInt();
            if(condition==0){
                System.out.println("|1|                 The END                   |0|");
            }
        }
    }
}
