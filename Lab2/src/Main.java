
public class Main {

	public static void main(String[] args) {
		
		// part 1
		
		PartOne p1 = new PartOne();
		System.out.println(p1.returnSmallerIntWithSameNbOfDiv(80));
		System.out.println(p1.returnSmallerIntWithSameNbOfDiv(48));
		
		// part 2
		
		PartTwo p2 = new PartTwo();
		int[] myArray = p2.createArray(120);
		
		System.out.println("array: ");
		p2.disp(myArray);
		
		System.out.println("index :");
		System.out.println(p2.index(new int[] {1, 2, 3, 4 , 12, 4567, 7, 0}, 4567));
		
		System.out.println("is prime: ");
		System.out.println(p2.isPrimeInside(myArray));
		
		// part 3
		
		PartThree p3 = new PartThree();
		
		p3.gameOnePlayer();
		
		System.out.println("\n two players game: \n");
		
		p3.gameTwoPlayers();
		
		// a little bit more
		ALittleBitMore albm = new ALittleBitMore();
		System.out.println(albm.factorial(6));
		
		albm.triangle(6);
		
	}

}
