//using instance variable for addition
class Addition{
    int firstNum, secondNum;
	public static void main(String[] args) {	
        Addition a =new Addition();	
        Addition b = new Addition();
        System.out.println("Instance 1:");
        a.takeInput();

        System.out.println("Instance 2: ");
        b.takeInput();;
	}


	void add(int firstNum, int secondNum){
		int result = firstNum + secondNum;
		displayOutput(result);
	}

	void takeInput(){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Enter two Numbers ");
        firstNum= scan.nextInt();
	    secondNum= scan.nextInt();
		add(firstNum, secondNum);
	}

	void displayOutput(int result){
		System.out.println("Addition : " + result);
	}


}
