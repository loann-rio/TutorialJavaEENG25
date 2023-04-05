package main;

class Station {
	
	private int idStation;
	private String name;
	
	public Station(int id, String nameStation)
	{
		idStation = id;
		name = nameStation;
	}
	
	public int getIdStation()
	{
		return idStation;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String toString()
	{
		return "id sation = "+idStation+" , name = "+name;
	}
}
