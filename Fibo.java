import java.util.Scanner;
class Fibo
{
	public static void main(String[] args)
	{
	
        int Number, i = 0, First = 0, Second = 1, Next;
		Scanner sc = new Scanner(System.in);		
		System.out.println("Please Enter any integer Value: ");
		Number = sc.nextInt();
		while(i < Number)  {
			if(i <= 1) {
				Next = i;
			}
			else  {
                Next = First + Second;
                First = Second;
                Second = Next;
			}
			System.out.println(Next);
			i++;
		}
	}
}