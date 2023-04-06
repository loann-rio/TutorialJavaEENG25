
public class PartOne {
	
	public int returnSmallerIntWithSameNbOfDiv(int N) {
		// get the number of divider of our number:
		int nbDivider = getNbDivider(N);
		
		// for every number under N:
		for (int i=1; i<N; i++) {
			// test if the number of divider is equal
			if (getNbDivider(i) == nbDivider) {
				// if they are equal return the number
				return i;
			}
		}
		
		// if no solution found, return -1
		return -1;
		
		// for a more efficient program, we could have used prime decomposition
		
	}
	
	int getNbDivider(int N) {
		int nbOfDivider = 0;
		
		// for all number under our number:
		for (int i=1; i<=N; i++) {
			// if the rest of the division is 0, increase the number of found divider
			if (N%i == 0) { nbOfDivider ++ ; }
		}
		
		return nbOfDivider;
	}
}