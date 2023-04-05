package javalab4;

public class People implements Comparable<People>{
	
	private String lastName;
	private String firstName;
			
	public People(String firstNameP, String lastNameP) {
		this.lastName = lastNameP;
		this.firstName = firstNameP;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "People [last name=" + lastName + ", first name=" + firstName + "]";
	}
	
	@Override
	public boolean equals(Object actor) {
		if (actor==null) return false;
		
		People p = (People) actor;
		if(this.lastName.equals(p.getLastName()) && this.firstName.equals(p.getFirstName()))
			return true;
		return false;
	}
	
	@Override
	public int compareTo(People pTmp) {
		return (pTmp.getLastName()+pTmp.getFirstName()).compareTo(this.lastName+this.firstName);
	}
	
}
