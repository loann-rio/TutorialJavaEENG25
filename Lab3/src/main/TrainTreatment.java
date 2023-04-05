package main;


public class TrainTreatment {
	MonthlyRegularity[] tabMR;
	
	public TrainTreatment(MonthlyRegularity[] tab) // constructor
	{
		tabMR = tab;
	}
	
	void display()
	{
		for (MonthlyRegularity e : tabMR)
		{
			System.out.println(e.toString());
		}
	}
	
	int nbOfMR(int idStation, int idStationTo)
	{
		int n = 0;
		for (int i=0; i<tabMR.length; i++)
		{
			if ((tabMR[i].getFRom().getIdStation() == idStation) && (tabMR[i].getTo().getIdStation() == idStationTo))
			{
				n++;
			}
		}
		return n;
	}
	
	String minDate()
	{
		int month = 13;
		int year = 12345670;
		for (MonthlyRegularity e : tabMR)
		{
			int y = e.getYear();
			int m = e.getMonth();
			if (y==year)
			{
				if (m<month)
				{
					month = m;
				}
			}
			if (y < year)
			{
				year = y;
				month = m;
			}
		}
		return "" + month + " " + year;
	}
	
	String maxDate()
	{
		int month = 0;
		int year = 0;
		for (MonthlyRegularity e : tabMR)
		{
			int y = e.getYear();
			int m = e.getMonth();
			if (y==year)
			{
				if (m>month)
				{
					month = m;
				}
			}
			if (y> year)
			{
				year = y;
				month = m;
			}
		}
		return "" + month + " " + year;
	}
	
	double pcRegularity(int idStation, int idStationTo)
	{
		double nbTot = 0;
		double nbCancel = 0;
		for (MonthlyRegularity e : tabMR)
		{
			if ((e.getFRom().getIdStation() == idStation) && (e.getTo().getIdStation() == idStationTo))
			{
				nbCancel += e.getNbTotalTrainsCanceled() + e.getNbTotalTrainsLate();
				nbTot += e.getNbTotalTrains();
			}
		}
		return 100- (nbCancel/nbTot)*100;
	}
	
	int[] histoMonthlyLate()
	{
		int[] array = new int[12];

		for (MonthlyRegularity e : tabMR)
		{
			array[e.getMonth()-1] += (int) e.getNbTotalTrainsLate();
		}
		return array;
	}
	
	double StRegularity()
	{
		double[] stationsLate = new double[59];
		double[] stationTot = new double[59];
		// double[] result = new double[59];
		// result can be use to save the result for all stations
		
		// for each MR, save number of train and number of late trains
		for (MonthlyRegularity e : tabMR)
		{
			stationsLate[e.getFRom().getIdStation()] += e.getNbTotalTrainsCanceled()+e.getNbTotalTrainsLate();
			stationTot[e.getFRom().getIdStation()] += e.getNbTotalTrains();
		}
		
		// get the minimum %
		
		double min = 100;
		for (int i=0; i<59; i++)
		{
			double r= 100 - 100 * stationsLate[i] / stationTot[i];
			if (r<min) { min = r;}
			
			// result[i] = r;
		}
				
		return min;
		
	}
	
	
}
