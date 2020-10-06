//The hoare partition version of quicksort

public class hoare{

    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];    
        arr[y] = temp;
    }

    static int hoarePartition(int[] arr, int start, int end){
        int pivot = arr[start]; 
        int i = start - 1, j = end + 1; 
  
        while (true) 
        { 
            do
            { 
                j--; 
            }while (arr[j] > pivot); 

            do
            { 
                i++; 
            }while (arr[i] < pivot); 
  
            if(i < j)      
                swap(arr,i,j);
            else
                return j;
        } 
    }
    
   static void sort(int[] arr, int start, int end){
       if(start<end){
           int pivot = hoarePartition(arr,start,end);
           sort(arr,start,pivot);
           sort(arr,pivot+1,end);
       }
   }

    public static void main(String[] args){
        int[] arr = new int[]{
            13,19,9,5,12,8,7,4,11,2,6,21
        };

        sort(arr,0,arr.length-1);
        
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
} 
