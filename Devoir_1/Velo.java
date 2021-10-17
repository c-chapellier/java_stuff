import java.util.Scanner;

public class Velo {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        if (debut < 0 || debut > 24 || fin < 0 || fin > 24) {
            System.out.println("Les heures doivent être comprises entre 0 et 24 !");
        } else if (debut == fin) {
            System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !");
        } else if (debut > fin) {
            System.out.println("Bizarre, le début de la location est après la fin ...");
        } else {
            int expensive = (debut < 17 && fin > 7)
                            ? (fin > 17 ? 17 : fin) - (debut < 7 ? 7 : debut)
                            : 0;
            int cheap = (fin - debut) - expensive;

            System.out.println("Vous avez loué votre vélo pendant");
            if (cheap != 0) {
                System.out.println(cheap + " heure(s) au tarif horaire de 1.0 franc(s)");
            }
            if (expensive != 0) {
                System.out.println(expensive + " heure(s) au tarif horaire de 2.0 franc(s)");
            }
            System.out.println("Le montant total à payer est de " + (cheap + 2*expensive) + ".0 franc(s).");
        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        clavier.close();
    }
}
