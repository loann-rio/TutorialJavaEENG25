
public class ALittleBitMore {
	
	public int factorial(int N)
	{
		int result = 1;
		for (int i=2; i<=N; i++)
		{
			result *= i; // result *= i is equivalent to result = result*i
		}
		return result;
		
		// if the given number is too big, the result will be to big to be an integer and the result will make no sense
	}
	
	public void triangle(int N)
	{
		// N should be odd
		for (int i = 1; i<=N; i++)
		{
			for (int j=0; j < (int) (N-(i*2-1))/2; j++)
			{
				System.out.print(" ");
			}
			
			for (int j = 0; j<i; j++)
			{
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	}
}
