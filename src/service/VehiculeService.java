package service;

import java.util.ArrayList;
import java.util.List;

import entity.Vehicule;


public class VehiculeService {


    private List<Vehicule> flotte = new ArrayList<>();

    private int compteurId = 1;


    public boolean ajouterVehicule(String marque, String modele, int kilometrage, double tarifJournalier) {
       if (kilometrage < 0) {
            return false;
        }
        if (tarifJournalier <= 0) {
            return false;
        }

        Vehicule v = new Vehicule(compteurId, marque, modele, kilometrage, tarifJournalier);
        compteurId++; // on prepare le prochain ID

        flotte.add(v);
        return true;
    }

   
    public List<Vehicule> getFlotte() {
        return flotte;
    }

  
    public boolean estVide() {
        return flotte.isEmpty();
    }

 
    public List<Vehicule> getVehiculesMoinsKilometrage() {
        List<Vehicule> resultat = new ArrayList<>();

       if (flotte.isEmpty()) {
            return resultat;
        }

         int kmMin = flotte.get(0).getKilometrage();
        for (Vehicule v : flotte) {
            if (v.getKilometrage() < kmMin) {
                kmMin = v.getKilometrage();
            }
        }

        // 2) On ajoute tous les vehicules qui ont ce kilometrage minimum.
        for (Vehicule v : flotte) {
            if (v.getKilometrage() == kmMin) {
                resultat.add(v);
            }
        }

        return resultat;
    }

 
    public double calculerTarifMoyen() {
        if (flotte.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (Vehicule v : flotte) {
            total += v.getTarifJournalier();
        }

        return total / flotte.size();
    }
}
