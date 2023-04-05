package javalab4;

import java.util.LinkedList;

public class DVDlibrary {
	
	private LinkedList<Movie> listMovies;
	
	public DVDlibrary(LinkedList<Movie> linkedList)
	{
		listMovies = linkedList;
	}
	
	int researchYear(int year)
	{
		int n = 0;
		for (Movie m:listMovies)
		{
			if (m.year == year) { n++; }
		}
		return n;
	}
	
	int nbMovieDirector(People dir)
	{
		int n = 0;
		for (Movie m:listMovies)
		{
			if (m.director == dir) { n++; }
		}
		return n;
	}
}
