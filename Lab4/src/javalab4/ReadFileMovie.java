package javalab4;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadFileMovie {
	
	private LinkedList<Movie> lMovies;
	private TreeSet<People> lDirectors;
	private TreeSet<People> lActors;
	private LinkedList<People> allPeople;

	public ReadFileMovie() {
		lMovies= new LinkedList<Movie>();
		lDirectors= new TreeSet<People>();
		lActors= new TreeSet<People>();
		allPeople=new LinkedList<People>();
	}
	
	public LinkedList<Movie> populateBaseRandom() {
		lMovies= new LinkedList<Movie>();
		int i;
		Random randomino =new Random();
		for(i=0;i<5;i++) {
			readFile(randomino.nextInt(20)+1);
		}
		System.out.println("Reat "+i+" files. Movies : "+lMovies.size()+" Directors : "+lDirectors.size()+" Actors : "+lActors.size());
		return lMovies;
	}
	public LinkedList<Movie> populateBase() {
		lMovies= new LinkedList<Movie>();
		int i;
		for(i=0;i<5;i++) {
			readFile(i*2+4);
		}
		System.out.println("Lecture de "+i+" fichiers. Movies : "+lMovies.size()+" Directors : "+lDirectors.size()+" Acteurs : "+lActors.size());
		return lMovies;
	}
	
	private void readFile(int numFile) {
		try {
			
			JSONParser parser = new JSONParser();
			
			Object obj = parser.parse(new FileReader("./data/films"+numFile+".txt"));
            JSONObject jsonObject = (JSONObject) obj;	
	        JSONArray results = (JSONArray)jsonObject.get("result");
	        JSONObject line;
	        String name, date;
	        JSONArray directorJson;
	        JSONArray actorJson;
	        Movie movieCurrent;
	        People directorCurrent; 
	        	      
	      for (Object result : results) {
	    	  line = (JSONObject) result;
	    	  
	    	  name = (String) line.get("name");
	    	  date = (String) line.get("/film/film/initial_release_date");
	    	  
	    	  directorJson=(JSONArray)line.get("directed_by");
	    	  directorCurrent=computeDirector(directorJson);
	    	  movieCurrent= computeMovie(name, directorCurrent, date);
	    	  if (movieCurrent!=null) {
	    		  allPeople.add(directorCurrent);
	    		  actorJson=(JSONArray)line.get("starring");
	    		  computeActor(movieCurrent,actorJson);
	    	  }
	      }
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
		System.out.println("Read file="+numFile+", Movies="+lMovies.size()+", Directors="+lDirectors.size()+", Actors="+lActors.size());
	}

	private Movie computeMovie(String name, People director, String date) {
		int iDate;
		if (date!=null) {
			iDate=Integer.parseInt(date.substring(0, 4));
		} else {
			iDate=0;
		}
		Movie f = new Movie(name, director, iDate);
		if (lMovies.contains(f)) {
			//System.out.println("Le Movie existe deja "+date+" "+nom);
			return null;
		}
		lMovies.add(f);
		return f;		
	}

	private void computeActor(Movie movieCurrent, JSONArray act) {
		String actorName;
		String[] tab;
		People aTmp;
		for (Object actorObj : act) {
			actorName = (String) ((JSONObject)actorObj).get("actor");
			if (actorName!=null) {		
				tab = actorName.split(" ");
				aTmp = new People(tab[0],tab[tab.length-1]);
				allPeople.add(aTmp);
				if(!lActors.add(aTmp)) {
					aTmp=lActors.ceiling(aTmp);
				}
				movieCurrent.addActor(aTmp);
			}	
		}	
	}
	
	private People computeDirector(JSONArray director) {
		String nameAll;
		if (director.size()==0) return null;
		nameAll = (String) director.get(0);
		if (nameAll==null) return null;
		String[] tab = nameAll.split(" ");
		People p = new People(tab[0],tab[tab.length-1]);
		if (!lDirectors.add(p)) {
			p=lDirectors.ceiling(p);
		}
		return p;	
	}

	public void displaySample(int nombre) {
		int i;
		Random randomino =new Random();
		for(i=0;i<nombre;i++) {
			System.out.println( lMovies.get(randomino.nextInt(lMovies.size())));
		}
	}

	public LinkedList<Movie> getMovies() {
		return lMovies;
	}

	public LinkedList<People> getAllPeople() {
		return allPeople;
	}
	

}
