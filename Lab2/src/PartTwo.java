import java.util.Random;

public class PartTwo {
	
	Random rand = new Random();

	public int[] createArray(int N) {
		// create an array of size N:
		int[] array = new int[N];
		
		// for every position in the array:
		for (int i=0; i<N; i++) {
			// add a random number, rand.nextInt give a random number from 0 to the given input (here 10000)
			array[i] = rand.nextInt(10000);
		}
		return array;
	}
	
	public void disp(int[] array) {
		// as an array is a pointer, we cannot display it directly using println, we need to print it
		// using the toString function
	
		System.out.println(array.toString());
	}
	
	public int index(int[] array, int obj) {
		// for every element of the array
		for (int i=0; i<array.length;i++) 
		{
			// if element at index is equal to wanted element:
			if (array[i] == obj) 
			{
				// return the index
				return i;
			}
		}
		// if element not found, return -1;
		return -1;
	}
	
	public boolean isPrimeInside(int[] array) {
		// we went to check for any element if it is prime, if one is found return false else continue
		for (int i=0; i< array.length;i++) {
			if (isPrime(array[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int num) {
        
		if (num <= 1) {
            return false;
        }
        
		// here, we test the divisibility by all number above 2, to go faster we could test only the prime numbers (as all non prime number can be divide by a prime number)
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        // if no divider was found the number is prime, return true
        return true;
	}
 }