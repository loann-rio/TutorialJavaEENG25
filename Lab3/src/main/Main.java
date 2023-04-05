package main;

public class Main {

	public static void main(String[] args)
	{
		
		// instantiate reader class 
		ReadTrainFile reader = new ReadTrainFile();
		
		// part 1:
		// see Station class
		
		//part 2:
		// monthly regulation contain all information about trains 
		// between two station during a month
		
		// the class correspond to a row on the table
		
		// the string method display all the information about the object
		
		// the getFileTrain return an array of all monthlyRegulation
		
		
		// Test your project by displaying the number of rows in the result array of the getFileTrain method.
		System.out.println(reader.getFileTrain().length);
		
		// Part 3
		
		// instantiate the class with the list of MonthlyRegulation as argument 
		TrainTreatment trainT = new TrainTreatment(reader.getFileTrain());
		
		// display:
		trainT.display();
		
		// nbOfMR:
		System.out.println("\n nb of MR: ");
		System.out.println(trainT.nbOfMR(0, 19)); // result should be 82
		
		// min date:
		System.out.println("\n minDate: ");
		System.out.println(trainT.minDate()); // result should be 9 2011
		
		// max date:
		System.out.println("\n maxDate: ");
		System.out.println(trainT.maxDate()); // result should be 6 2018
		
		// pcRegularity:
		System.out.println("\n pcRegularity: ");
		System.out.println(trainT.pcRegularity(0, 19)); // result should be  93.16%
		
		// histoMonthlyLate:
		new DisplayHisto(trainT.histoMonthlyLate());
		
		
		// A little bit more ?
		// station regularity:
		System.out.println("\n station Regularity: ");
		System.out.println(trainT.StRegularity());

	}

}
