public class maxHeap{

    static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void maxHeapify(int arr[], int i, int n){        //Here n is the size. We don't need to pass size for heapify
        int largest;                                        //however when we use it for sorting we need to decrease the size
        int l = 2*i;                                        //of array by one in each iteration. Therefore we decrease n and pass
        int r = 2*i+1;                                      //as the actual size of array is same, just that we are ignoring it.
        if(l<n && arr[l]>arr[i])
            largest = l;
        else
            largest = i;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            swap(arr, i, largest);
            maxHeapify(arr,largest,n);
        }

    }

    static void buildMaxHeap(int arr[]){
        int n = arr.length;
        for (int i = n/2; i> 0; i--){
            maxHeapify(arr,i,n);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{
            Integer.MIN_VALUE,4,1,3,2,16,9,10,14,8,7        //The 0 index has a garbage value to satisfy the heap rules of left child = 2*index.
        };                                                  //The array should begin from index one to satisfy the heap rules.
        int n = arr.length;

        //Building and printing the heap
        buildMaxHeap(arr);
        System.out.println("Max Heap -->");
        for(int i=1; i<arr.length; i++){                    //Not printing out the 0 index
            System.out.print(arr[i]+" ");
        }

        //Sorting Process O(nlgn)
        for(int i = n-1;i>1;i--){
            swap(arr,1,i);
            n--;
            maxHeapify(arr,1,n);
        }

        System.out.println("\nSorted Array -->");
        for(int i=1; i<arr.length; i++){                  //Again ignoring the 0 index
            System.out.print(arr[i]+" ");
        }
    }
}