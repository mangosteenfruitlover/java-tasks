package prakt15.work1;
import java.util.Scanner;
public class List_Functions{
    Scanner scanner=new Scanner(System.in);
    List first=null;
    List last=null;
    public void adding(int N){
        if(N==-1){
            System.out.println("N: ");
            N=scanner.nextInt();
            for(int i=0;i<N;i++){
                System.out.println((i+1)+"/"+N+" | Value = ?");
                adding(i);
            }
        }else{

            List list=new List();
            list.i_value=scanner.nextInt();
            if(first==null){
                first=list;
                last=list;
            }else{
                last.next=list;
                list.previous=last;
                last=list;
            }
        }
    }
    public void deleting(){
        System.out.println("|2|                 DELETing                  |2|");
        System.out.println("Value = ?");
        int i_value=scanner.nextInt();
        List list=first;
        while(list!=null){
            if(list.i_value==i_value){
                if(list.previous!=null)
                    list.previous.next=list.next;
                else
                    first=list.next;
                if(list.next!=null)
                    list.next.previous=list.previous;
                else
                    last=list.previous;
                break;
            }
            list=list.next;
        }
        if(list==null){
            System.out.println("Not found");
        }
    }
    public void finding_by_value(){
        System.out.println("|3|              FINDing by Value             |3|");
        System.out.println("Value = ?");
        int i_value=scanner.nextInt();
        int i=0;
        List list=first;
        while(list!=null){
            i++;
            if(list.i_value==i_value){
                System.out.println("Index = "+i);
                break;
            }
            list=list.next;
        }
        if(list==null){
            System.out.println("Not found");
        }
    }
    public void finding_by_key(){
        System.out.println("|4|               FINDing by Key              |4|");
        System.out.println("Index = ?");
        List list=first;
        int index=scanner.nextInt();
        for(int i=0;i<index-1;i++){
            if(list==null){
                System.out.println("None");
                return;
            }
            list=list.next;
            if(list==null){
                System.out.println("None");
                return;
            }
        }
        System.out.println("Value: "+list.i_value);
    }
    public void finding_max(){
        System.out.println("|5|             FINDing Max Value             |5|");
        int max=0;
        List list=first;
        while(list!=null){
            max=Math.max(list.i_value,max);
            list=list.next;
        }
        System.out.println("Value = "+max);
    }
    public void finding_min(){
        System.out.println("|6|             FINDing Min Value             |6|");
        int min=Integer.MAX_VALUE;
        List list=first;
        while(list!=null){
            min=Math.min(list.i_value,min);
            list=list.next;
        }
        System.out.println("Value = "+min);
    }
    public void finding_Middle(){
        System.out.println("|7|           FINDing Average Value           |7|");
        int middle=0;
        int size=0;
        List list=first;
        while(list!=null){
            size++;
            middle+=list.i_value;
            list=list.next;
        }
        System.out.println("Value: "+middle/size);
    }
    public void displaying(){
        System.out.println("|8|                DISPLAYing                 |8|");
        List list=first;
        int i=1;
        while(list!=null){
            System.out.print(i+" | "+list.i_value+"\n");
            list=list.next;
            i++;
        }
        System.out.println();
    }
}
