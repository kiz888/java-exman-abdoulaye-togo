package view;

import java.util.List;
import java.util.Scanner;

import entity.Vehicule;
import service.VehiculeService;


public class MainView {

    private Scanner scanner = new Scanner(System.in);
    private VehiculeService service = new VehiculeService();

    public static void main(String[] args) {
        MainView vue = new MainView();
        vue.demarrer();
    }

   
    public void demarrer() {
        boolean continuer = true;

        while (continuer) {
            afficherMenu();
            int choix = lireEntier("Votre choix : ");

            switch (choix) {
                case 1:
                    ajouterVehicule();
                    break;
                case 2:
                    afficherTousLesVehicules();
                    break;
                case 3:
                    afficherVehiculesMoinsKilometrage();
                    break;
                case 4:
                    afficherTarifMoyen();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez reessayer.");
            }
        }
    }

   
    private void afficherMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1. Ajouter un vehicule");
        System.out.println("2. Afficher tous les vehicules de la flotte");
        System.out.println("3. Afficher le(s) vehicule(s) avec le moins de kilometres");
        System.out.println("4. Afficher le tarif moyen de location journalier");
        System.out.println("5. Quitter");
        System.out.println("========================================");
    }
    private void ajouterVehicule() {
        System.out.println("\n--- Ajouter un vehicule ---");

        System.out.print("Marque : ");
        String marque = scanner.nextLine().trim();

        System.out.print("Modele : ");
        String modele = scanner.nextLine().trim();

        int kilometrage = lireEntier("Kilometrage : ");
        double tarif = lireDouble("Tarif journalier (EUR) : ");

        // On demande au service d'ajouter (c'est lui qui verifie les regles).
        boolean ajoute = service.ajouterVehicule(marque, modele, kilometrage, tarif);

        if (ajoute) {
            System.out.println("[OK] Vehicule ajoute avec succes !");
        } else {
            System.out.println("[ERREUR] Le kilometrage doit etre >= 0 et le tarif journalier > 0.");
        }
    }

     private void afficherTousLesVehicules() {
        System.out.println("\n--- Liste des vehicules ---");

        List<Vehicule> flotte = service.getFlotte();

        // RG2 : la View verifie si la flotte est vide.
        if (flotte.isEmpty()) {
            System.out.println("Le parc automobile est actuellement vide.");
        } else {
            for (Vehicule v : flotte) {
                System.out.println(v); // utilise toString()
            }
        }
    }

      private void afficherVehiculesMoinsKilometrage() {
        System.out.println("\n--- Vehicule(s) avec le moins de kilometres ---");

        List<Vehicule> resultat = service.getVehiculesMoinsKilometrage();

        if (resultat.isEmpty()) {
            System.out.println("Le parc automobile est actuellement vide.");
        } else {
            for (Vehicule v : resultat) {
                System.out.println(v);
            }
        }
    }

      private void afficherTarifMoyen() {
        System.out.println("\n--- Tarif moyen de location ---");

        double moyenne = service.calculerTarifMoyen();

           System.out.printf("Tarif moyen : %.2f EUR / jour%n", moyenne);
    }

    
    private int lireEntier(String message) {
        while (true) {
            System.out.print(message);
            String saisie = scanner.nextLine().trim();
            try {
                return Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entier valide.");
            }
        }
    }


    private double lireDouble(String message) {
        while (true) {
            System.out.print(message);
            String saisie = scanner.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(saisie);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide (ex: 45.50).");
            }
        }
    }
}
