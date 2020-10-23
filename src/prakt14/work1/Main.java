package prakt14.work1;

import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static ArrayList<Student> students=new ArrayList();
    static ArrayList <Integer>iDNumber=new ArrayList();
    static Student student1=new Student(1000,3.5,"First_Student");
    static Student student2=new Student(1001,4.5,"Second_Student");
    static Student student3=new Student(1002,4.9,"Third_Student");
    static SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
    public static void main(String[] args){
        Output();

    }
    public static int[] Output(){
        students.add(student1);

        students.add(student2);

        students.add(student3);

        students.forEach(student->iDNumber.add(student.iDNumber));

        Collections.sort(iDNumber);

        iDNumber.forEach(id->System.out.println(id));

        Collections.sort(students,sortingStudentsByGPA);

        students.forEach(student -> System.out.println(student.nameStudent+" "+student.dMark));
        students.forEach(student -> iDNumber.add(student.iDNumber));
        int[] res=new int[iDNumber.size()];
        for (int i = 0; i <iDNumber.size(); i++) {
            res[i] = iDNumber.get(i);
        }
        return res;
    }
}