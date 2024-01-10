package fr.angers.volaillefx;
abstract class Volaille {

    //Definition des variables
    private String numeroIdentification;
    private int id;
    private double poids;
    private double prixJour;
    private double poidsAbattage;

    public Volaille(int id, double poids, String numeroIdentification) {
        this.id = id;
        this.poids = poids;
        this.numeroIdentification = numeroIdentification;
    }

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(String numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoids() {
        return poids;
    }

    public void setId(double poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Volaille{" +
                "numeroIdentification='" + numeroIdentification + '\'' +
                ", id=" + id +
                ", poids=" + poids +
                '}';
    }
}
