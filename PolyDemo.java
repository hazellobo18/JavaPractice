class Calculate{
   int total;
    int add(int... values){
    if(values.length==0){
        System.out.print("You need atleast two numbers to add!");
        return 0;
    }
    else{
        for(int val: values)
            {
                total+=val;
            }
    return total;
    }
    }

   /* int add(int a, int b){
        return a+b;

    }
    int add(int a, int b, int c){
        return a+b+c;
    }
    int add(int a, int b, int c,int d){
        return a+b+c+d;
    }*/
}
class PolyDemo{
    /*static int total;
    static int add(int... values){
        for(int val: values)
            {
                total+=val;
            }
    return total;
    }*/


    public static void main(String[] args) {

        System.out.println("Sum:"+ new Calculate().add(10,20));
        System.out.println("Sum:"+ new Calculate().add(10,20,50));
        System.out.println("Sum:"+ new Calculate().add(10,20,432));
        System.out.println("Sum:"+ new Calculate().add());

        //System.out.print("Addition:"+add(10,20));





    }

}