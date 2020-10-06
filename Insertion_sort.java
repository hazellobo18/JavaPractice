public class Insertion_sort{
    
    static void insertionSort(int[] arr, int start, int end){
        if(start != end){
            insertionSort(arr, start, end-1);
            int key = arr[end];
            int i = end - 1;
            while(i >= 0 && arr[i] > key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }
    
    public static void main(String[] args){

        int[] arr = new int[]{
            5,2,4,6,1,3
        };

        //Printing the array before sorting
        System.out.println("Before Sort - ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();

        insertionSort(arr,0,arr.length-1);

        //Printing the array after sorting
        System.out.println("After Sort - ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}