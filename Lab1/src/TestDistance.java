import java.lang.Math;

public class TestDistance {
		
	public boolean testDistancebtwTwoPoints(float[] point1, float[] point2, float dist) {
		
		// to go a step further:
		
		/* 
		 * here, we want to know if the distance between two points is smaller than a given distance
		 * To do so, first we need to calculate the distance between the two points, we use Pythagoras theorem
		 * As java does not contain a power or sqrt function originally, we import the package Math.  
		 * 
		 * the function take 2 float array as argument and a float for the distance
		 * the teacher would have probably liked if an other class 'point' was created and used for this.
		 */
		
		return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2)) < dist;
		
		
	}

}
