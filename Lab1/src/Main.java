
public class Main {

	public static void main(String[] args) {
		
		// part 1:
		
		HelloWord speaker = new HelloWord();
		
		speaker.sayHello();		
		speaker.sayHelloTo("loann");
		
		// part 2:
		
		RobotCalculator clank = new RobotCalculator();
		
		System.out.println(clank.avg(12f, 15.5f)); // here, we add an f after the number to precise it's a float
		
		clank.avgMultStident();
		
		
		// to go a step further:
		
		TestDistance ruler = new TestDistance();
		
		System.out.println(ruler.testDistancebtwTwoPoints(new float[] {1f, 2f}, new float[] {13.2f, 15f}, 10));
			
	}

}
