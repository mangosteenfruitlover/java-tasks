package prakt18;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int itask=4;
        while((itask!=0)){
            switch(itask){
                case 1:
                    new Task1().start(args);
                    break;
                case 2:
                    new Task2().start(args);
                    break;
                case 3:
                    new Task3().start(args);
                    break;
                case 4:
                    System.out.println("###TASK### |4| Menu |4|");
                    System.out.println("###TASK### 1) start Task1; ");
                    System.out.println("###TASK### 2) start Task2; ");
                    System.out.println("###TASK### 3) start Task3; ");
                    System.out.println("###TASK### 4) show   Menu; ");
                    System.out.println("###TASK### 0) Exit. ");
                    break;

                default:

                    break;
            }
            System.out.println("###TASK### |I| Input (0..4):... ");
            itask=scanner.nextInt();
        }
    }

    public static class Task1{
        public void start(String[] args){
            System.out.println("###TASK### |1| Task1 |1|");
            System.out.println("###|1|### num=...");
            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();

            int lastDecomposed=decompose(number);
            if(lastDecomposed!=1)
                System.out.println(lastDecomposed);
        }

        private int decompose(int number){
            for(int i=2;i<=9;i++){
                if(number%i==0){
                    number=number/i;
                    System.out.println(i);
                    if(number>1){
                        return decompose(number);
                    }
                    return number;
                }
            }
            return number;
        }
    }

    public static class Task2{
        private int growNumber;
        private int dropNumber;
        private String word;
        private boolean lastResult=false;

        public void start(String[] args){
            System.out.println("###TASK### |2| Task2 |2|");
            System.out.println("###|2|### Word=...");
            Scanner scanner=new Scanner(System.in);
            word=scanner.next();

            growNumber=0;
            dropNumber=word.length()-1;

            process();
            System.out.println(lastResult);
        }

        private void process(){
            if(growNumber>dropNumber){
                return;
            }

            if(word.charAt(growNumber)==word.charAt(dropNumber)){
                lastResult=true;
                growNumber++;
                dropNumber--;
                process();
            }else{
                lastResult=false;
            }
        }
    }

    public static class Task3{
        public void start(String[] args){
            System.out.println("###TASK### |3| Task3 |3|");
            System.out.println(findMax());
        }

        private int findMax(){
            System.out.println("###|3|### num=...");
            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();
            int maxNumber=number;

            if(number!=0){
                int newNumber=findMax();
                if(newNumber>maxNumber)
                    maxNumber=newNumber;
            }

            return maxNumber;
        }
    }
}
