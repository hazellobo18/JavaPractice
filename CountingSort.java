public class CountingSort{
    public static void main(String[] args){
        int[] A = new int[]{
            2,5,3,0,2,3,0,3
        };
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[6];

        for(int i = 0;i<n;i++){
            C[A[i]]++;
        }

        for(int i = 1; i<6;i++){
            C[i] = C[i-1] + C[i];
        }

        for(int i = 0;i<n;i++){
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }

        for(int i = 0;i<n;i++){
            System.out.print(B[i]+" ");
        }
        //To print the C array
        /*for(int i = 0;i<6;i++){
            System.out.print(C[i]+" ");
        }*/
    }
}