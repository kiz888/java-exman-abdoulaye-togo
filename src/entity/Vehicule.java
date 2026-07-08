package entity;

public class Vehicule {

    private int id;                
    private String marque;         
    private String modele;         
    private int kilometrage;        
    private double tarifJournalier; 

    public Vehicule(int id, String marque, String modele, int kilometrage, double tarifJournalier) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.tarifJournalier = tarifJournalier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getTarifJournalier() {
        return tarifJournalier;
    }

    public void setTarifJournalier(double tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }

        @Override
    public String toString() {
        return "ID: " + id
                + " | Marque: " + marque
                + " | Modele: " + modele
                + " | Kilometrage: " + kilometrage + " km"
                + " | Tarif: " + tarifJournalier + " EUR/jour";
    }
}
