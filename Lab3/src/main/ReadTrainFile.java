package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadTrainFile {
	/**
	 * ReadTrainFile Version 1.17
	 */
	private LinkedList<Station> stations;
	private ArrayList<MonthlyRegularity> lignesRM;
	private boolean readError;

	public ReadTrainFile() {
		stations = new LinkedList<Station>();
		lignesRM = new ArrayList<MonthlyRegularity>();
		readError = false;
	}

	public MonthlyRegularity[] getFileTrain() {
		int i;
		if (lignesRM.size() < 1)
			readFile();
		if (readError)
			return null;
		MonthlyRegularity[] tab = new MonthlyRegularity[lignesRM.size()];
		for (i = 0; i < tab.length; i++) {
			tab[i] = lignesRM.get(i);
		}

		System.out.println("Lecture : " + stations.size() + " stations, " + lignesRM.size() + " lignes");
		// System.out.println(stations);
		return tab;
	}

	// Le fichier doit �tre dans le dossier du projet (et non dans scr)
	private void readFile() {
		String nomFichier = "regularite-mensuelle-tgv.csv";
		// String nomFichier = "regularite-mensuelle-ter.csv";
		BufferedReader entree;
		MonthlyRegularity rmTemp;
		try {
			entree = new BufferedReader(new FileReader(nomFichier));
			String ligne = entree.readLine();
			while (ligne != null) {
				ligne = entree.readLine();
				if (ligne != null) {
					rmTemp = lineTreat(ligne);
					if (rmTemp != null)
						lignesRM.add(rmTemp);
				}
			}
			entree.close();
		} catch (Exception e) {
			readError = true;
			e.printStackTrace();
		}
	}

	private MonthlyRegularity lineTreat(String ligne) {
		// System.out.println(ligne);
		MonthlyRegularity rmTemp;
		String[] tab = ligne.split(";");
		if (tab.length < 8) {
			// System.out.println("Non parsable : " + ligne);
			return null;
		}

		Station depart = findAddStation(tab[3]);
		Station arrivee = findAddStation(tab[4]);

		if (tab[7].length() < 1)
			tab[7] = "0.0";
		if (tab[13].length() < 1)
			tab[13] = "0.0";

		try {
			rmTemp = new MonthlyRegularity((int) Double.parseDouble(tab[1]), Integer.parseInt(tab[0]), depart,
					arrivee, Double.parseDouble(tab[6]), Double.parseDouble(tab[7]), Double.parseDouble(tab[13]));
		} catch (Exception e) {
			System.out.println("Non parsable : " + ligne);
			rmTemp = null;
		}

		return rmTemp;
	}

	private Station findAddStation(String stationName) {
		Station g = null;
		int i;
		int id;
		for (i = 0; i < stations.size(); i++) {
			if (stations.get(i).getName().equals(stationName)) {
				g = stations.get(i);
			}
		}
		if (g == null) {
			if (stations.size() == 0)
				id = 0;
			else
				id = stations.getLast().getIdStation() + 1;
			g = new Station(id, stationName);
			stations.add(g);
		}
		return g;
	}

}
