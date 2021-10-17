import java.util.Scanner;

public class Champi {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        System.out.println("Pensez a un champignon : amanite tue mouches, pied bleu, girolle,");
        System.out.println("cèpe de Bordeaux, coprin chevelu ou agaric jaunissant.\n");

        System.out.print("Est-ce que votre champignon a un chapeau convexe (true : oui, false : non) ? ");
        if (clavier.nextBoolean())
        {
            // agaric amanite pied bleu
            System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ? ");
            if (clavier.nextBoolean())
            {
                // amanite pied bleu
                System.out.print("Est-ce que votre champignon a un anneau (true : oui, false : non) ? ");
                if (clavier.nextBoolean()) {
                    System.out.println("==> Le champignon auquel vous pensez est l'amanite tue-mouches.");
                } else {
                    System.out.println("==> Le champignon auquel vous pensez est le pied bleu.");
                }
            }
            else {
                System.out.println("==> Le champignon auquel vous pensez est l'agaric jaunissant.");
            }
        }
        else
        {
            // cèpe coprin girolle
            System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ? ");
            if (clavier.nextBoolean())
            {
                // cèpe girolle
                System.out.print("Est-ce que votre champignon a des lamelles (true : oui, false : non) ? ");
                if (clavier.nextBoolean()) {
                    System.out.println("==> Le champignon auquel vous pensez est la girolle.");
                } else {
                    System.out.println("==> Le champignon auquel vous pensez est le cèpe de Bordeaux.");
                }
            }
            else {
                System.out.println("==> Le champignon auquel vous pensez est le coprin chevelu.");
            }
        }

        clavier.close();
    }
}
