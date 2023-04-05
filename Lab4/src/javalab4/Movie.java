package javalab4;

import java.util.LinkedList;

public class Movie {
	public String title;
	
	public People director = new People("unknown", "unknown");
	LinkedList<People> actors = new LinkedList<People>();
	int year;
	
	public Movie(String titleP, People directorP, int yearP)
	{
		title = titleP;
		director = directorP;
		year = yearP;
	}
	
	public String toString()
	{
		String r=  "Movie :"+title+":\n year= "+year+"\n director= "+director.toString()+"\n actors = [ ";
		for (People a : actors)
		{
			r+= a.toString() + " ";
			
		}
		return r+"]";
	}
	
	public boolean equals(Movie o)
	{
		return (title == o.title);
	}
	
	public void addActor(People a)
	{
		actors.add(a);
	}

}
