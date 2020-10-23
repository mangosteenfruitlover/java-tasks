package prakt14.work1;

public class Find{
    public static int lineRecSearch(int[] array,int elementToSearch,int index){
        if(array[index]==elementToSearch)
            return index;
        else if(index<=array.length)
            return lineRecSearch(array,elementToSearch,index+1);
        else return -1;
    }

    public int recursiveBinarySearch(int array[],int firstElement,int lastElement,int elementToSearch){


        if(lastElement>=firstElement){
            int mid=firstElement+(lastElement-firstElement)/2;


            if(array[mid]==elementToSearch)
                return mid;


            if(array[mid]>elementToSearch)
                return recursiveBinarySearch(array,firstElement,mid-1,elementToSearch);


            return recursiveBinarySearch(array,mid+1,lastElement,elementToSearch);
        }

        return -1;
    }

    public static int lineSearch(int array[],int elementToSearch){
        for(int index=0;index<array.length;index++){
            if(array[index]==elementToSearch)
                return index;
        }
        return -1;
    }

    public int binarySearch(int array[],int elementToSearch){

        int firstIndex=0;
        int lastIndex=array.length-1;

        while(firstIndex<=lastIndex){
            int middleIndex=(firstIndex+lastIndex)/2;
            if(array[middleIndex]==elementToSearch){
                return middleIndex;
            }else if(array[middleIndex]<elementToSearch)
                firstIndex=middleIndex+1;


            else if(array[middleIndex]>elementToSearch)
                lastIndex=middleIndex-1;

        }
        return -1;
    }

}