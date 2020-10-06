/*
    This solves the question 4.1-2 and 4.1-3 on page 74 of CLRS 3rd edition.
    The brute-force approach is faster uptill n = 342 approx.
    After that Divide and Conquer performs better.
*/

import java.util.Random;

class Solution{
    private int low;
    private int high;
    private int max;
    public Solution(int low, int high, int max){
        this.low = low;
        this.high = high;
        this.max = max;
    }

    public int getLow(){
        return this.low;
    }
    public int getHigh(){
        return this.high;
    }
    public int getMax(){
        return this.max;
    }
}

public class maxSubArray{
    static Solution findMaxSubArray(int[] arr, int low, int high){
        if(low == high){
            return new Solution(low,high,arr[low]);
        }else{
            int mid = (low+high)/2;
            Solution leftSide = findMaxSubArray(arr, low, mid);
            Solution rightSide = findMaxSubArray(arr, mid+1, high);
            Solution maxCrossing = findMaxCrossArray(arr, low, mid, high);
            if(leftSide.getMax() > rightSide.getMax() && leftSide.getMax()> maxCrossing.getMax()){
                return leftSide;
            }else if(rightSide.getMax() > leftSide.getMax() && rightSide.getMax() > maxCrossing.getMax()){
                return rightSide;
            }else{
                return maxCrossing;
            }
        }
    }

    static Solution findMaxCrossArray(int arr[], int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for(int i = mid; i>=low;i--){
            sum += arr[i];
            if(sum>leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid+1;
        for(int i = mid+1; i<=high;i++){
            sum += arr[i];
            if(sum>rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }
        return new Solution(maxLeft, maxRight, leftSum+rightSum);
    }

    public static void main(String[] args){
        //The CLRS array below however, we'll be using the random numbers between -10 and 10
        //int[] arr = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        
        //Code to generate an array of random numbers withing the range(-10,10)
        Random rd = new Random();
        int[] arr = new int[10];
        for(int k = 0;k<arr.length;k++){
            arr[k] = rd.nextInt(20) - 10;
        }
        int n = arr.length;

        System.out.println("Divide and Conquer Approach ------");
        long start = System.nanoTime();             
        Solution answer = findMaxSubArray(arr,0,n-1);
        //for question 4.1-4
        /*if(answer.getMax() < 0){
            answer = new Solution(-1,-1,0);
        }*/
        long end = System.nanoTime();
        long elapsedTime = end - start;


        System.out.println("Low : "+answer.getLow()+" High : "+answer.getHigh()+" Max value : "+answer.getMax());
        System.out.println("Time taken : "+ elapsedTime+" nanosecs");


        System.out.println("\nBrute Force Approach ------");
        int max = Integer.MIN_VALUE;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        start = System.nanoTime();
        for(int i = 0;i <n-1;i++){
            sum = 0;
            for(int j = i;j<n;j++){
                sum += arr[j];
                if(sum>max){
                    max = sum;
                    leftMax = i;
                    rightMax = j;
                }
            }
        }
        //for question 4.1-4
        /*if(max < 0){
            max = 0;
            leftMax = -1;
            rightMax = -1;
        }*/
        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("Low : "+leftMax+" High : "+rightMax+" Max value : "+max);
        System.out.println("Time taken : "+ elapsedTime+" nanosecs");
        
        //Use the below code to visualize the array
        /*System.out.print("Array -> ");
        for(int i =0; i<arr.length;i++){
            System.out.print("|"+arr[i]);
        }
        System.out.print("|");*/
    }
}
