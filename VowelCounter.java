import java.util.Scanner;
class VowelCounter{
    public static void main(String[] args)
     {

        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        input =input.toLowerCase();
        int vowels=0;

        for (int i=0; i < input.length();i++){
            char ch= input.charAt(i);
            if(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u')
                vowels++;
        }
        System.out.println("Vowels:"+vowels);
        System.out.println("Constants:"+(input.length()-vowels));
       
    }

}
