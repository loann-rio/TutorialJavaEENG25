package main;

public class MonthlyRegularity {
	/**
	 * RegulariteMensuelle
	 * Version 1.17
	 */
	private int month;
	private int year;
	private Station from;
	private Station to;
	private double nbTotalTrains;
	private double nbTotalTrainsCanceled;
	private double nbTotalTrainsLate;
	
	public MonthlyRegularity(int mois, int annee, Station depart, Station arrivee,
			double nbTotalTrains, double nbTotalTrainsAnnules, double nbTotalTrainsRetard) {
		this.month = mois;
		this.year = annee;
		this.from = depart;
		this.to = arrivee;
		this.nbTotalTrains = nbTotalTrains;
		this.nbTotalTrainsCanceled = nbTotalTrainsAnnules;
		this.nbTotalTrainsLate = nbTotalTrainsRetard;
	}

	public MonthlyRegularity(int mois, int annee, Station depart, Station arrivee) {
		this.month = mois;
		this.year = annee;
		this.from = depart;
		this.to = arrivee;
		this.nbTotalTrains = 0;
		this.nbTotalTrainsCanceled = 0;
		this.nbTotalTrainsLate = 0;
	}
	
	@Override
	public String toString() {
		return "MonthlyRegularity [month=" + month + ", year=" + year
				+ ", from=" + from + ", to=" + to
				+ ", nbTotalTrains=" + nbTotalTrains
				+ ", nbTotalTrainsCanceled=" + nbTotalTrainsCanceled
				+ ", nbTotalTrainsLate=" + nbTotalTrainsLate + "]";
	}

	/*****************Accessors********************/
	

	public double getNbTotalTrains() {
		return nbTotalTrains;
	}

	public void setNbTotalTrains(double nbTotalTrains) {
		this.nbTotalTrains = nbTotalTrains;
	}

	public double getNbTotalTrainsCanceled() {
		return nbTotalTrainsCanceled;
	}

	public void setNbTotalTrainsCanceled(double nbTotalTrainsAnnules) {
		this.nbTotalTrainsCanceled = nbTotalTrainsAnnules;
	}

	public double getNbTotalTrainsLate() {
		return nbTotalTrainsLate;
	}

	public void setNbTotalTrainsLate(double nbTotalTrainsRetard) {
		this.nbTotalTrainsLate = nbTotalTrainsRetard;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public Station getFRom() {
		return from;
	}

	public Station getTo() {
		return to;
	}


}
