package prakt14.work1;

import java.util.Scanner;

public class Main14{
    static Sorting sorting=new Sorting();
    static Find find=new Find();
    static Main main13=new Main();
    static int[] old_array=main13.Output();
    static int new_array[]=null;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(true){
            int iInput=sc.nextInt();
            if(iInput==0){
                break;
            }
            int iCondition=sc.nextInt();

            if(iInput==1){
                sorting.quickSort(old_array,0,old_array.length-1);
                new_array=old_array;

            }else if(iInput==2){
                sorting.mergesort(old_array);
                new_array=old_array;

            }else{
                new_array=null;

            }


            if(iInput==1){
                System.out.println(find.binarySearch(new_array,iCondition));
                break;

            }else if(iInput==2){
                System.out.println(find.recursiveBinarySearch(new_array,new_array[0],new_array[new_array.length-1],iCondition));
                break;

            }else if(iInput==3){
                if(new_array!=null)
                    System.out.println(find.lineSearch(new_array,iCondition));
                break;

            }else if(iInput==4){
                if(new_array!=null)
                    System.out.println(find.lineRecSearch(new_array,iCondition,0));
                break;

            }else if(iInput==0){
                break;

            }

        }

    }

}
