package fr.angers.volaillefx;

import java.util.ArrayList;
import java.util.List;
/**
 * La classe Elevage représente un élevage de volailles, comprenant des poulets et des canards.
 * Elle permet d'ajouter des volailles, de trier et d'abattre les canards et poulets prêts à l'abattage.
 * Chaque volaille ajoutée est également enregistrée dans une liste globale.
 */
public class Elevage {
    private List<Poulet> poulets;
    private List<Canard> canards;
    private List<Volaille> volaillesList;

    private static int lastId = 0;

    /**
     * Constructeur par défaut de la classe Elevage.
     * Initialise les listes de poulets, de canards et de volailles.
     */
    public Elevage() {
        this.poulets = new ArrayList<>();
        this.canards = new ArrayList<>();
        this.volaillesList = new ArrayList<>();
    }

    /**
     * Ajoute un poulet à l'élevage en utilisant les informations fournies via l'interface graphique.
     *
     * @param poids               Le poids du poulet.
     * @param numeroIdentification Le numéro d'identification du poulet.
     */
    public void ajouterPouletsViaGui(double poids, String numeroIdentification) {
        Poulet poulet = new Poulet(++lastId, poids, numeroIdentification);
        ajouterPoulets(poulet);
    }

    /**
     * Ajoute un canard à l'élevage en utilisant les informations fournies via l'interface graphique.
     *
     * @param poids               Le poids du canard.
     * @param numeroIdentification Le numéro d'identification du canard.
     */
    public void ajouterCanardsViaGui(double poids, String numeroIdentification) {
        Canard canard = new Canard(++lastId, poids, numeroIdentification);
        ajouterCanards(canard);
    }

    /**
     * Récupère la liste globale de volailles de l'élevage.
     *
     * @return La liste de volailles.
     */
    public List<Volaille> getVolaillesList() {
        return volaillesList;
    }

    /**
     * Ajoute un poulet à l'élevage.
     *
     * @param poulet Le poulet à ajouter.
     */
    public void ajouterPoulets(Poulet poulet) {
        poulets.add(poulet);
        volaillesList.add(poulet);
    }

    /**
     * Ajoute un canard à l'élevage.
     *
     * @param canard Le canard à ajouter.
     */
    public void ajouterCanards(Canard canard) {
        canards.add(canard);
        volaillesList.add(canard);
    }

    /**
     * Trie et abat les canards prêts à l'abattage, calculant le prix total.
     *
     * @return Le prix total des canards abattus.
     */
    public double trierEtAbattreCanard() {
        double prixCannard = 0;

        System.out.println("Canard à abattre :");
        for (Canard canard : canards) {
            if (canard.getPoidsAbattage() <= canard.getPoids()) {
                System.out.println(canard);
                prixCannard += canard.getPoids();
            }
        }
        return prixCannard;
    }

    /**
     * Trie et abat les poulets prêts à l'abattage, calculant le prix total.
     *
     * @return Le prix total des poulets abattus.
     */
    public double trierEtAbattrePoulet() {
        double prixPoulet = 0;
        System.out.println("Poulets à abattre :");
        for (Poulet poulet : poulets) {
            if (Poulet.getPoidsAbattage() <= poulet.getPoids()) {
                System.out.println(poulet);
                prixPoulet += poulet.getPoids();
            }
        }
        return prixPoulet;
    }

    public double nbAbattreCanard() {
        double nbCannard = 0;

        System.out.println("Canard à abattre :");
        for (Canard canard : canards) {
            if (canard.getPoidsAbattage() <= canard.getPoids()) {
                System.out.println(canard);
                nbCannard += 1;
            }
        }
        return nbCannard;
    }

    public double nbAbattrePoulet() {
        double nbPoulet = 0;
        System.out.println("Nb Poulets à abattre :");
        for (Poulet poulet : poulets) {
            if (Poulet.getPoidsAbattage() <= poulet.getPoids()) {
                System.out.println(poulet);
                nbPoulet += 1;
            }
        }
        return nbPoulet;
    }


    /**
     * Récupère le nombre de poulets restants qui ne sont pas prêts à l'abattage.
     *
     * @return Le nombre de poulets restants.
     */
    public int getPouletsRestants() {
        int pouletsRestants = 0;
        for (Poulet poulet : poulets) {
            if (poulet.getPoidsAbattage() > poulet.getPoids()) {
                pouletsRestants++;
            }
        }
        return pouletsRestants;
    }


    public int getCanardsRestants() {
        int canardsRestants = 0;
        for (Canard canard : canards) {
            if (canard.getPoidsAbattage() > canard.getPoids()) {
                canardsRestants++;
            }
        }
        return canardsRestants;
    }

}
