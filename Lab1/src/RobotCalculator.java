
public class RobotCalculator {
	
	private Keyboard keyboard = new Keyboard();
	
	public float avg(float note1, float note2) {
		return (note1+note2)/2;
	}
	
	public void avgMultStident() {
		
		
		System.out.println("input the number of student : ");
		int N = keyboard.readInt();
		
		float overAllAvg = 0;
		
		for (int i=0; i<N; i++) {
			
			System.out.println("input the first grade of student n°" + i + " :");
			float grade1 = keyboard.readFloat();
			
			System.out.println("input the second grade :");
			float grade2 = keyboard.readFloat();
			
			System.out.println("the average of this student is " + avg(grade1, grade2));
			
			overAllAvg += avg(grade1, grade2)/N;
			
		}
		System.out.println("the overall average of the class is  "+ overAllAvg);
	}
}
