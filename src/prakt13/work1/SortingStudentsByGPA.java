package prakt13.work1;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student>{
    @Override
    public int compare(Student _first_student,Student _second_student){

        if(_first_student.dMark<_second_student.dMark){

            return 1;

        }

        if(_first_student.dMark>_second_student.dMark){

            return -1;

        }

        return 0;

    }

}
