/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class Patient {

    private double masse;
    private double hauteur;

    public void init(double masse, double hauteur)
    {
        if (masse < 0.0 || hauteur < 0.0) {
            this.masse = 0.0;
            this.hauteur = 0.0;
        } else {
            this.masse = masse;
            this.hauteur = hauteur;
        }
    }

    public void afficher()
    {
        System.out.printf("Patient : %.1f kg pour %.1f m\n", this.masse, this.hauteur); 
    }

    public double poids()
    {
        return this.masse;
    }

    public double taille()
    {
        return this.hauteur;
    }

    public double imc()
    {
        if (this.hauteur == 0.0) {
            return 0.0;
        }
        return this.masse / Math.pow(this.hauteur, 2.0);
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}
