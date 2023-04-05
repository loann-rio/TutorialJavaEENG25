package javalab4;


public class Main {

	public static void main(String[] args) {

		// part 1
		// create 2 instance of People:
		People ryan = new People("ryan", "gosling");
		People carey = new People("carey", "mulligan");
		
		
		// test toString:
		System.out.println("ryan.toString :");
		System.out.println(ryan.toString());
		
		
		// test equals
		// this function compare to People to tell if they are the same:
		// as equals is an Override of '==' we can use == to call the function:
		// a==b is equivalent to a.equals(b)
		
		System.out.println("equals :");
		
		System.out.println("ryan == carey");
		System.out.println(ryan == carey);
		
		People ryanCopy = ryan;
		System.out.println("\nryan == ryanCopy");
		System.out.println(ryan == ryanCopy);
		
		
		// test compareTo
		/* from chatGPT:
		 * 
		 * In Java, compareTo() is a method that allows you to compare two objects and determine if they are equal to each other or if 
		 * one is greater or less than the other. It's like a game where you have two cards, and you need to figure out which one is higher.

		 * Let's say you have two numbers, 5 and 10. If you wanted to compare them, you could use compareTo() to see which one is greater. 
		 * If you called 5.compareTo(10), the method would return a negative number because 5 is less than 10. If you called 10.compareTo(5), 
		 * the method would return a positive number because 10 is greater than 5. And if you called 5.compareTo(5), the method would return 0 
		 * because they are equal.

		 * You can also use compareTo() to compare other types of objects, like strings. If you had two strings, "apple" and "banana", you could 
		 * call "apple".compareTo("banana") to see which one comes first in alphabetical order.
		 * 
		 */
		
		System.out.println("compareTo");
		
		System.out.println("\nryan.compareTo(carey)");
		System.out.println(ryan.compareTo(carey));
		
		System.out.println("\nryan.compareTo(ryanCopy)");
		System.out.println(ryan.compareTo(ryanCopy));
		
		System.out.println("\ncarey.compareTo(ryan)");
		System.out.println(carey.compareTo(ryan));
		
		// create Movie class
		// => see Movie
		
		
		// create a movie:
		Movie drive = new Movie("drive", new People("Nicolas", "REFN"), 2011);
		drive.addActor(ryan);
		drive.addActor(carey);
		System.out.println("\r\n" + drive.toString()); // "\r\n" is used to skip a line
		
		// part 2
		
		ReadFileMovie fileM = new ReadFileMovie();
		
		System.out.println("\npopulateBase:");
	
		fileM.populateBase();
		fileM.displaySample(20);
		
		System.out.println("\npopulateBaseRandom:");
		
		fileM.populateBaseRandom();
		fileM.displaySample(20);
		
		
		// part 3
		
		// see DVDlibery
		DVDlibrary lib = new DVDlibrary(fileM.populateBase());
		
		System.out.println("\nlib.researchYear(1997)");
		
		System.out.println(lib.researchYear(1997));
		
		// doesn't work, don't know why:
		//System.out.println(lib.nbMovieDirector(new People("Alfred", "Hitchcock")));
		
		
		// part 4
		
		
		Duplicate duplicate = new Duplicate();
		
		double t = System.currentTimeMillis();
		duplicate.getPeopleList(fileM.getAllPeople());
		
		System.out.print("\n it took ");
		System.out.print(System.currentTimeMillis()-t);
		System.out.println(" ms to get the people list using binaryTree");

	}

}
