// Max sub array in Linear time 
// Answer to question 4.1-5

public class maxSubArrayLinear{
    static int maximum(int a, int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        //For random array
        /*Random rd = new Random();
        int[] arr = new int[10];
        for(int k = 0;k<arr.length;k++){
            arr[k] = rd.nextInt(20) - 10;
        }*/
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        for(int i = 1;i<n;i++){
            arr[i] = maximum(arr[i], arr[i]+arr[i-1]);
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Maximum value is "+max);
        //Use the below code to visualize the array
        /*System.out.print("Array -> ");
        for(int i =0; i<arr.length;i++){
            System.out.print("|"+arr[i]);
        }
        System.out.print("|");*/
    }
}