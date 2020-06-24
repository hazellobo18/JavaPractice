import java.util.Scanner;
class Pallindrome{    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        input= input.toLowerCase();
        String rev="";
        for(int i=input.length()-1; i >= 0; i--){
            rev+=input.charAt(i);
        }
        if(input.equals(rev))
            System.out.println("Pallindrome");
        else
        System.out.println("Not Pallindrome");
    }
}