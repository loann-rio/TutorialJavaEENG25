import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Class : Keyboard                                                                                                   
 *  Description : The class implements input methods for primitive types from the keyboard. 
 */
public class Keyboard {
	/**
	 * Return a String typed on keyboard
	 * @return : a string
	 */
	public  String readString() {
		String sChaine = null;
		//System.out.println("Enter a value :");
		try  {
			// read the value
			BufferedReader brLecteur ;
			brLecteur = new BufferedReader(new InputStreamReader(System.in));
			sChaine = brLecteur.readLine();
		}
		catch (IOException ee) {
			System.out.println("Error");
		}
		return sChaine;  // return the string
	}

	/**
	 * Return an Integer typed on keyboard
	 * @return : an integer
	 */
	public  int readInt() {
		String sChaine = readString(); // call readString
		// cast from string to int
		return Integer.parseInt(sChaine.trim());
	}

	/**
	 * Return a float typed on keyboard
	 * @return : a float 
	 */
	public  float readFloat() {
		String sChaine = readString();
		// cast from string to float		
		return Float.parseFloat(sChaine.trim());
	}

	/**
	 * Return a double typed on keyboard
	 * @return : a double
	 */
	public  double readDouble() {
		String sChaine = readString();
		// cast frome string to double
		return Double.parseDouble(sChaine.trim());
	}

}