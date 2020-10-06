//Max-Priority Queue

import java.util.Arrays;
import java.util.Scanner;

public class priorityQueue{

    private static Scanner scanner = new Scanner(System.in);

    private static int CAPACITY = 100;
    private static int size = 0;

    private static int[] arr = new int[CAPACITY];

    private static void ensureSIZE(){
        if(size+1 == CAPACITY){
            arr = Arrays.copyOf(arr, CAPACITY*2);
            CAPACITY = CAPACITY*2;
        }
    }

    private static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void maxHeapify(int i){
        int largest;
        int l = 2*i;
        int r = 2*i+1;
        if(l<size && arr[l] > arr[i])
            largest = l;
        else   
            largest = i;
        if(r<size && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            swap(i,largest);
            maxHeapify(largest);
        }
    }

    private static void insert(int k){
        ensureSIZE();
        size += 1;
        arr[size] = Integer.MIN_VALUE;
        heapIncreaseKey(size,k);
    }

    private static int heapMax(){
        if(size>0){
            return arr[1];
        }else{
            System.out.println("ERROR: Queue Empty");
            return -1;
        }
        
    }

    private static int extractMax(){
        if(size<1){
            System.out.println("ERROR: Queue Empty");
            return -1;
        }else{
            int max = arr[1];
            arr[1] = arr[size];
            size--;
            maxHeapify(1);
            return max;
        }
    }

    private static void heapIncreaseKey(int i,int k){
        if(k < arr[i]){
            System.out.println("ERROR: Given key smaller than current key");
        }else{
            arr[i] = k;
            while(i>1 && arr[i/2]<arr[i]){
                swap(i,i/2);
                i = i/2;
            }
        }
    }

    public static void main(String[] args){
        int c,k,i;
        System.out.println("Enter Choice -->");
        printchoice();
        c = 0;
        while(c!=7){
            c = scanner.nextInt();
            
            switch(c){
                case 1: k = scanner.nextInt();
                        insert(k);
                        break;
                case 2: i = scanner.nextInt();
                        k = scanner.nextInt();
                        heapIncreaseKey(i, k);
                        break;
                case 3: System.out.println("Maximum is: "+heapMax());
                        break;
                case 4: System.out.println("Extracted maximum is:"+extractMax());
                        break;
                case 5: printArray();
                        break;
                case 6: printchoice();
                        break;
                case 7: System.out.println("Quitting---");
                        break;
            }
        }
    }

    static void printchoice(){
        System.out.println("\t1. Insert");
        System.out.println("\t2. Change key");
        System.out.println("\t3. Show Maximum");
        System.out.println("\t4. Extract Maximum");
        System.out.println("\t5. Print Array");
        System.out.println("\t6. Show choices");
        System.out.println("\t7. Quit");        
    }

    static void printArray(){
        for(int j = 1; j<= size; j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}