import java.util.Scanner;
class Season{
public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    int var= s.nextInt();
    
    switch(var){
        case 1: case 2: case 12:
            System.out.println("WINTER");
            break;

        case 3: case 4: case 5:
            System.out.println("Spring");
            break;
        
        case 6: case 7: case 8:
            System.out.println("Summer");
            break;
        
        case 9: case 10: case 11:
            System.out.println("Autumn");
            break;

        default:
            System.out.println("No Such Season exists");
            break;
    }
}
    
}