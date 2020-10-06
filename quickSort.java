//Randomized QuickSort

import java.util.Random;

public class quickSort{
    
    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;
        for(int j = i+1;j<end;j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return i+1;
    }

    static int randomize(int[] arr, int start, int end){
        Random rd = new Random();
        int randomNumber = rd.nextInt(end-start)+start;  //Getting a random number between start and end
        swap(arr,randomNumber,end);                      //Swapping it with last index because last index is selected as pivot in partition function
        return partition(arr, start, end);               //Calling the partition function and returning the pivot index
    }

    static void sort(int[] arr, int start, int end){
        if(start<end){
            int pivot = randomize(arr,start,end);        //Calling randomize before calling partition
            sort(arr,start,pivot-1);
            sort(arr,pivot+1,end);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{
            2,8,7,1,3,5,6,4
        };

        sort(arr,0,arr.length-1);
        
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");    
        }
    }
}