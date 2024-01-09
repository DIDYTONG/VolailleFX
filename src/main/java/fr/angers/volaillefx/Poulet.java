package fr.angers.volaillefx;


/**
 * La classe Poulet représente une volaille de type poulet, héritant de la classe Volaille.
 * Elle contient des propriétés spécifiques telles que le poids d'abattage et le prix par jour.
 */
class Poulet extends Volaille {

    //Definition des variables
    private static double poidsAbattage = 0;
    private static double prixJour = 0;


    /**
     * Constructeur de la classe Poulet.
     *
     * @param id                 L'identifiant du poulet.
     * @param poids              Le poids du poulet.
     * @param numeroIdentification Le numéro d'identification du poulet.
     */
    public Poulet(int id, double poids, String numeroIdentification) {
        super(id, poids, numeroIdentification);
    }


    /**
     * Définit le poids d'abattage pour tous les poulets.
     *
     * @param poidsAbattage Le poids d'abattage à définir.
     */
    public static void setPoidsAbattage(double poidsAbattage) {
        Poulet.poidsAbattage = poidsAbattage;
    }

    /**
     * Récupère le poids d'abattage spécifique à un poulet.
     *
     * @return Le poids d'abattage du poulet.
     */
    public static double getPoidsAbattage() {
        return Poulet.poidsAbattage;
    }

    /**
     * Définit le prix par jour pour tous les poulets.
     *
     * @param prixJour Le prix par jour à définir.
     */
    public static void setPrixJour(double prixJour) {
        Poulet.prixJour = prixJour;
    }

    /**
     * Récupère le prix par jour spécifique à un poulet.
     *
     * @return Le prix par jour du poulet.
     */
    public static double getPrixJour() {
        return Poulet.prixJour;
    }
}