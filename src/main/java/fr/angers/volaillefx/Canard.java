package fr.angers.volaillefx;

/**
 * La classe Canard représente une volaille de type canard, héritant de la classe Volaille.
 * Elle contient des propriétés spécifiques telles que le poids d'abattage et le prix par jour.
 */
class Canard extends Volaille {

    //Definition des variables
    private static double poidsAbattage = 0;
    private static double prixJour = 0;


    /**
     * Constructeur de la classe Canard.
     *
     * @param id                 L'identifiant du canard.
     * @param poids              Le poids du canard.
     * @param numeroIdentification Le numéro d'identification du canard.
     */
    public Canard(int id, double poids, String numeroIdentification) {
        super(id, poids, numeroIdentification);
    }


    /**
     * Définit le poids d'abattage pour tous les canards.
     *
     * @param poidsAbattage Le poids d'abattage à définir.
     */
    public static void setPoidsAbattage(double poidsAbattage) {
        Canard.poidsAbattage = poidsAbattage;
    }

    /**
     * Récupère le poids d'abattage spécifique à un canard.
     *
     * @return Le poids d'abattage du canard.
     */
    public double getPoidsAbattage() {
        return poidsAbattage;
    }

    /**
     * Définit le prix par jour pour tous les canards.
     *
     * @param prixJour Le prix par jour à définir.
     */
    public static void setPrixJour(double prixJour) {Canard.prixJour = prixJour; }

    /**
     * Récupère le prix par jour spécifique à un canard.
     *
     * @return Le prix par jour du canard.
     */
    public static double getPrixJour() {
        return Canard.prixJour;
    }

}